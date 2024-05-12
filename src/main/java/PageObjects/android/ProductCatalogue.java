package PageObjects.android;
import PageObjects.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {

    AndroidDriver driver;
    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);//
    }
    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc='ProductsListing/Title']")
    private List<WebElement> TitleProducts;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement ComparisonButton;

    public String getTitleProductByIndex(int index){
        return TitleProducts.get(index).getText();
    }
    public void selectIconComparisonByIndex(int index) {
        // Construiește XPath-ul pentru a găsi iconul de comparație pentru produsul specificat prin index
        String xpath = "(//android.view.ViewGroup[@content-desc='ProductsListing/CardContainer'])["+ (index+1) +"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup";

        // Găsește elementul folosind XPath-ul construit
        WebElement icon = driver.findElement(By.xpath(xpath));

        // Face clic pe iconul de comparație
        icon.click();
    }
    public ComparisonPage ClickComparisonButton(){
        ComparisonButton.click();
        return new ComparisonPage(driver);
    }


}


