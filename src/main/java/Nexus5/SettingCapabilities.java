package Nexus5;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SettingCapabilities {
    private DesiredCapabilities capabilities;
    private String deviceName;
    private String udId;
    private String appPackage;
    private String appActivity;
    private int appWaitDuration;

    public SettingCapabilities(String deviceName, String udId, int appWaitDuration,String appPackage,String appActivity) {
        capabilities = new DesiredCapabilities();
        this.deviceName = deviceName;
        this.udId = udId;
        this.appWaitDuration = appWaitDuration;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        setDesiredCapabilities();
    }

    private void setDesiredCapabilities() {
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity",appActivity );
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appWaitDuration", appWaitDuration);

        try {
            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }
}
