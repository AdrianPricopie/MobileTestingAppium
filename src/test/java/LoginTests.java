import PageObjects.android.AccountPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginTests extends Configuration {


    @Test(dataProvider="getData")
    public void testLogin(HashMap<String ,String> input) {
        AccountPage accountPage  =  homePage.clickMyAccountTab();
        accountPage.ClickAutenthButton();
        accountPage.EnterEmail(input.get("ValidEmail"));
        accountPage.EnterPassword(input.get("ValidPassword"));
        accountPage.ClickLogin();
        accountPage.VerifyThatExistMyOrderInPage();
    }


    @Test(dataProvider="getData")
    public void testLogout(HashMap<String ,String> input) {
        AccountPage accountPage  =  homePage.clickMyAccountTab();
        accountPage.ClickAutenthButton();
        accountPage.EnterEmail(input.get("ValidEmail"));
        accountPage.EnterPassword(input.get("ValidPassword"));
        accountPage.ClickLogin();
        accountPage.scrollToText("Logout");
        accountPage.ClickLogout();
        accountPage.VerifyAutenthIsPresent();
    }
    @Test(dataProvider="getData")
    public void testLoginWithInvalidPass(HashMap<String ,String> input) throws InterruptedException {
        AccountPage accountPage  =  homePage.clickMyAccountTab();
        accountPage.ClickAutenthButton();
        accountPage.EnterEmail(input.get("ValidEmail"));
        accountPage.EnterPassword(input.get("InvalidPassword"));
        accountPage.ClickLogin();
        accountPage.VerifyErrorMessageIsDisplayed();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//TestData//eCommerce.json");
        return new Object[][] {  {data.get(0)} };
    }

}