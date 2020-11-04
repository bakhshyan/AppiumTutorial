import Nexus5.SettingCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollTest  {
    SettingCapabilities capabilities;
    WebDriver driver;
    @Test
    public void testScroll() {
        driver = new ChromeDriver();
        capabilities = new SettingCapabilities("Nexus 5", "09a84576029a0193", 10000,"com.android.vending","com.google.android.finsky.activities.MainActivity");
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.android.vending:id/tab_recycler_view\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"Games We Are Playing\")"));

//Perform the action on the element
        element.click();
    }
}
