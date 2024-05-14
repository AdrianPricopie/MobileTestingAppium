import PageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class searchFunctionalityTests extends Configuration {

    @Test(dataProvider="getData",groups = {"Smoke"})
    public void TestSearchProduct(HashMap<String ,String> input) {
        homePage.clickSearch();
        homePage.typeProductInSearchField(input.get("Product"));
        ProductCatalogue productCatalogue = homePage.pressEnter();
        String ActualResult = productCatalogue.getTitleProductByIndex(0);
        Assert.assertTrue(ActualResult.contains(input.get("Product")));
    }
    @Test(dataProvider="getData")
    public void testSearchForNonExistentProduct(HashMap<String,String>input) {
        homePage.clickSearch();
        String inexisting_product = input.get("InexistingProduct");
        homePage.typeProductInSearchField(inexisting_product);
        homePage.pressEnter();
        String result_text = homePage.getTitleForNoResultProduct();
        String expectedResult = "Ne pare rau, cautarea ta " + inexisting_product + " nu a avut niciun rezultat. Verifica daca ai scris corect sau incearca sa cauti folosind alt termen.";
        Assert.assertEquals(result_text, expectedResult);
    }
    @Test(groups = {"Smoke"})
    public void isHomePageDisplayed() {
        boolean isFirstPage = homePage.VerifyDisplayed();
        Assert.assertTrue(isFirstPage, "Not on the first page");
    }
    @Test(dataProvider="getData")
    public void testSearchWithFewerCharacters(HashMap<String,String>input) {
        homePage.clickSearch();
        homePage.typeProductInSearchField(input.get("TwoCharacter")); // Fewer characters
        homePage.pressEnter();

        // Verify that the minimum characters message is displayed
        boolean isMessageDisplayed = homePage.VerifyMinimumCharacterMessageEle();
        Assert.assertTrue(isMessageDisplayed, "Minimum characters message is not displayed");
    }
    @Test()
    public void testSearchWithEmptyInput() {
        homePage.clickSearch();
        homePage.typeProductInSearchField("");
        homePage.pressEnter();

        // Verify that the minimum characters message is displayed
        boolean isMessageDisplayed = homePage.VerifyMinimumCharacterMessageEle();
        Assert.assertTrue(isMessageDisplayed, "Minimum characters message is not displayed");
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        // Modify the path to your JSON file
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//TestData//eCommerce.json");
        return new Object[][] {  {data.get(0)},{data.get(1)}  };
    }


}
