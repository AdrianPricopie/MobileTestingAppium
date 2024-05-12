package PageObjects.android;
import PageObjects.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ComparisonPage extends AndroidActions {

    AndroidDriver driver;

    public ComparisonPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//
    }

    public boolean VerifyVisibilityTitle(String title) {
        boolean firstProductTitle = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='ProductsListing/Title' and @text='" + title + "']")).isDisplayed();
        return firstProductTitle;
    }


}
