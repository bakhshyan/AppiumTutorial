package CATS60;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ParrallelTest implements Runnable {
    String port;
    String udid;
    String deviceName;

    public ParrallelTest(String port, String udid, String deviceName) {
        this.port = port;
        this.udid = udid;
        this.deviceName = deviceName;

    }

    AppiumDriver<WebElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();


    public void openAppAndPerformSomeActions() {

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appWaitDuration", "200000");

        try {
            driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
            Thread.sleep(100000);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Runnable r1 = new ParrallelTest("5000", "09a84576029a0193", "Nexus");
        Runnable r2 = new ParrallelTest("4723", "S601628001664", "Cat S60");
        new Thread(r1).start();
        new Thread(r2).start();
    }
    public void run() {
        openAppAndPerformSomeActions();
    }
}