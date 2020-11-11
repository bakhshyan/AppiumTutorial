import PhonesCapabilites.CatS60Capabilites;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollTest implements CatS60Capabilites {
    AppiumDriver<MobileElement> driver;
    SettingCapabilites phoneCapabilites;

    @BeforeMethod
    public void setPhoneCapabilites()  throws MalformedURLException  {
        phoneCapabilites= new SettingCapabilites(deviceName,udid,platformName,platformVersion,appPackage,appActivity,noReset,appWaitDuration);
        phoneCapabilites.setCapabilites();
        driver = phoneCapabilites.driver;

    }

    @Test
    public void ScrollTest() {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.android.vending:id/tab_recycler_view\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"Games We Are Playing\")"));


            driver.findElement(MobileBy.AndroidUIAutomator())

    }
}
