import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    static DesiredCapabilities capabilities;
    static AppiumDriver<MobileElement> driver;

    public static void main(String args[]) throws MalformedURLException {
        setCapabilities();
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        findElement();

    }

    public static void setCapabilities() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 5");
        capabilities.setCapability("udid", "09a84576029a0193");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appWaitDuration", 10000);
    }

    public static void findElement() {
//        driver.findElementByXPath("//*[@text='Top charts']").click()
        //driver.findElementByXPath("//*[@content-desc='Voice Search']").click();
        //driver.findElementByXPath("//*[@resource-id='com.android.vending:id/0_resource_name_obfuscated']/*[@text='Top charts']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Top charts']").click();

    }
}