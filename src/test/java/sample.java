
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

public class sample {

    private AndroidDriver driver;

    @BeforeSuite
    public void setup() throws  Exception{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/swrajitpaul/Desktop/app-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.findElementById("button_first").click();

    }
}