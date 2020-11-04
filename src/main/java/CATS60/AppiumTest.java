package CATS60;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    public void firstTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","CAT S60");
        caps.setCapability("udid","S601628001664");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","6.0.1");
        caps.setCapability("appPackage","com.android.vending");
        caps.setCapability("appActivity","com.google.android.finsky.activities.MainActivity");
        caps.setCapability("noReset","true");
        caps.setCapability("appWaitDuration","200000");

        try {
            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
