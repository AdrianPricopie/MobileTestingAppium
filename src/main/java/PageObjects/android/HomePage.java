package PageObjects.android;
import PageObjects.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AndroidActions {

    AndroidDriver driver;
    public HomePage(AndroidDriver driver){
        super(driver);
         this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);//
    }
    @AndroidFindBy(accessibility="MyAccountTab")
    private WebElement MyAccountTab;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Cauta produsul dorit']")
    private WebElement search;
    @FindBy(className="android.widget.EditText")
    private WebElement productInputField;
    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    private WebElement noResultProduct;
    @FindBy(className = "android.widget.ImageView")
    private WebElement imageCatalogue;
    @FindBy(xpath = "//android.widget.TextView[@text='Utilizati cel putin 3 caractere.']")
    private WebElement minimumCharactersMessageElement;

    public  void clickSearch(){
        search.click();
    }
    public void typeProductInSearchField(String product){
        productInputField.sendKeys(product);
    }
    public ProductCatalogue pressEnter(){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        return new ProductCatalogue(driver);
    }
    public String getTitleForNoResultProduct(){
        return noResultProduct.getText().replace("\"", "");
    }
    public boolean VerifyDisplayed(){
       return imageCatalogue.isDisplayed();
    }
    public boolean VerifyMinimumCharacterMessageEle(){
        return minimumCharactersMessageElement.isDisplayed();
    }
    public AccountPage clickMyAccountTab(){
        MyAccountTab.click();
        return new AccountPage(driver);
    }



}
