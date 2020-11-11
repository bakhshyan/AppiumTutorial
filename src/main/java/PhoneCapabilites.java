import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class PhoneCapabilites {
    private String deviceName;
    private String udid;
    private String platformName;
    private String platformVersion;
    private String appPackage;
    private String appActivity;
    private boolean noReset;
    private int appWaitDuration;

    private DesiredCapabilities caps;
    public AppiumDriver<MobileElement> driver;

    public PhoneCapabilites(String deviceName, String udid, String platformName, String platformVersion, String appPackage, String appActivity, boolean noReset, int appWaitDuration) {
        this.deviceName = deviceName;
        this.udid = udid;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.noReset = noReset;
        this.appWaitDuration = appWaitDuration;


    }

    public void setCapabilites() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid",udid);
        caps.setCapability("platformVersion",platformVersion);
        caps.setCapability("platformName",platformName);
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity",appActivity);
        caps.setCapability("noReset",noReset);
        caps.setCapability("appWaitDuration",appWaitDuration);

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }


}
