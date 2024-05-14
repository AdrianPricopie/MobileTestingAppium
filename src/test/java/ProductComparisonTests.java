import PageObjects.android.ComparisonPage;
import PageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;





public class ProductComparisonTests extends Configuration {

    @Test(groups = {"Smoke"})
    public void testComparisonOfTwoProducts() {
        homePage.clickSearch();
        homePage.typeProductInSearchField("Televizor");
        ProductCatalogue productCatalogue = homePage.pressEnter();
        String TitleFirstProduct = productCatalogue.getTitleProductByIndex(0);
        String TitleSecondProduct = productCatalogue.getTitleProductByIndex(1);
        productCatalogue.selectIconComparisonByIndex(0);
        productCatalogue.selectIconComparisonByIndex(1);
        ComparisonPage comparisonPage = productCatalogue.ClickComparisonButton();
        Assert.assertTrue(comparisonPage.VerifyVisibilityTitle(TitleFirstProduct), "Primul produs nu este afișat în pagina de comparație");
        Assert.assertTrue(comparisonPage.VerifyVisibilityTitle(TitleSecondProduct), "Al doilea produs nu este afișat în pagina de comparație");
    }

}