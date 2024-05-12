package PageObjects.android;

import PageObjects.Utils.AndroidActions;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AndroidActions {

    AndroidDriver driver;

    public AccountPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);//
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Auth/LoginButton']/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement authentificationButton;
    @AndroidFindBy(accessibility = "emailField")
    private WebElement EmailField;
    @AndroidFindBy(accessibility = "passwordField")
    private WebElement PasswordField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='loginButton']/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement LoginButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Comenzile mele']/android.view.ViewGroup")
    private WebElement MyOrder;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Logout']/android.view.ViewGroup")
    private WebElement LogoutButton;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Email sau parola invalid/a']")
    private WebElement errorMessage;


    public void ClickAutenthButton(){
        authentificationButton.click();
    }
    public void EnterEmail(String keys){
        EmailField.sendKeys(keys);
    }
    public void EnterPassword(String keys){
        PasswordField.sendKeys(keys);
    }
    public void ClickLogin(){
        LoginButton.click();
    }
    public void VerifyThatExistMyOrderInPage(){
        Assert.isTrue(MyOrder.isDisplayed(),"MyOrder is not present in my account");
    }
    public void ClickLogout(){
        LogoutButton.click();
    }
    public void VerifyAutenthIsPresent(){
        Assert.isTrue(authentificationButton.isDisplayed(),"Autenth button is not displayed after logout");
    }
    public void VerifyErrorMessageIsDisplayed() throws InterruptedException {
        Thread.sleep(8000);
        Assert.isTrue(errorMessage.isDisplayed(),"Error message is not displayed");
    }



}