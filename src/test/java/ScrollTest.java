import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollTest{
    AppiumDriver<MobileElement> driver;

    public ScrollTest() throws MalformedURLException {
        PhoneCapabilites phoneCapabilites = new PhoneCapabilites("Nexus 5", "09a84576029a0193", "Android", "6.0.1", "com.android.vending", "com.google.android.finsky.activities.MainActivity", true, 20000);
        phoneCapabilites.setCapabilites();
        driver = phoneCapabilites.driver;
    }

    @Test
    public void testBaseClass() {
        System.out.println(driver);

    }
}
