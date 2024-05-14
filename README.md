# Altex Mobile Testing Project with Appium 

## Description

This project is dedicated to testing the Altex mobile application using the Appium framework in Java programming language, along with TestNG for managing and executing tests. IntelliJ IDEA is used as the code editor for development, and tests are run on the BrowserStack cloud. The tests focus on functionalities such as login, search, and product comparison.

## About aplication

[Altex](https://altex.ro/) is one of the largest retail chains in Romania, offering a wide range of electronics, home appliances, IT&C products, furniture, and more. The Altex.ro application is the online extension of this store chain, providing customers with a convenient way to purchase desired products directly from their mobile devices.

## Tools and Technologies Used

- [Appium](https://appium.io/): Framework for mobile test automation.
- [Java](https://www.java.com/): Programming language used for writing tests.
- [TestNG](https://testng.org/): Unit and integration testing platform for Java.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/): Code editor used for development.
- [BrowserStack](https://www.browserstack.com/): Cloud testing platform for running tests on various devices and browsers.
- [Emulator](https://developer.android.com/studio)
- [Appium inspector](https://github.com/appium/appium-inspector)
- [Maven](https://maven.apache.org/)
- Test Devices:
  - Samsung S22 Ultra
  - Google Pixel 6
  - Samsung S21
- Android 12/11: Operating system used on the test devices.

### Project Structure

1. **src/main/java/PageObjects**:
   - *Description*: Represents each web page as a separate class using the Page Object Model (POM) design pattern, aiding in creating reusable and maintainable code.

2. **src/main/java/Utils/AndroidActions**:
   - *Description*: Contains utility classes or methods specifically tailored for performing actions on Android devices in a mobile automation project, such as tapping and swiping.

3. **src/main/java/Resources/data.properties**:
   - *Description*: Stores various configuration parameters in a key-value pair format.

4. **src/test/java/Resources/Altex_3.0.0_Apkpure.apk**:
   - *Description*: The APK file serves as the deployment package for the Altex application in mobile application testing scenarios, allowing test automation frameworks to install and execute tests on Android devices.

5. **src/ExtentReport/**:
   - *Description*: Stores ExtentReports generated during test automation executions, providing interactive and detailed reports.

6. **src/test/TestData/eCommerce.json**:
   - *Description*: Test data file used to provide input data for test cases, define expected outcomes, or configure test environments.

7. **src/test/java/AppiumUtils**:
   - *Description*: Utility classes for loading data from JSON files during tests and for starting and managing a local Appium server for testing, promoting modular and maintainable code.

8. **src/test/java/Configuration**:
   - *Description*: Responsible for setting up and configuring the Appium environment, initializing the Android driver, and performing cleanup tasks after test execution.

9. **src/test/java/Listeners**:
   - *Description*: Acts as a listener for TestNG test events, generating Extent reports with detailed execution results, crucial for analyzing test outcomes.

10. **src/test/java/ExtentReporterNG**:
    - *Description*: Facilitates the creation and configuration of Extent reports, providing necessary settings for generating comprehensive and visually appealing test reports.

11. **browserstack.yml**:
    - *Description*: Configuration file providing settings for authentication, specifying project and build details, defining platforms/devices for testing, configuring BrowserStack Local, and enabling debugging features for enhanced test analysis.

12. **TestNGSuite/**:
    - *Description*: Defines a test suite including multiple test classes and specifies a listener for handling test events.

13. **pom.xml**:
    - *Description*: Defines project metadata, build configurations, properties, and dependencies required for building and running the Appium framework design project.


## Tests

### testLogin

This test verifies the login functionality in the Altex application. The user enters their valid email address and password and then attempts to log in.

#### Steps:
1. Access the "My Account" tab in the application.
2. Click on the authentication button.
3. Enter the valid email address and password.
4. Click the login button.
5. Verify that the user's order exists on the account page to ensure that I am logged in.

code: 
   ```java
   @Test(dataProvider="getData",groups = {"Smoke"})
    public void testLogin(HashMap<String ,String> input) {
        AccountPage accountPage  =  homePage.clickMyAccountTab();
        accountPage.ClickAutenthButton();
        accountPage.EnterEmail(input.get("ValidEmail"));
        accountPage.EnterPassword(input.get("ValidPassword"));
        accountPage.ClickLogin();
        accountPage.VerifyThatExistMyOrderInPage();
    }

   ```

### testLogout

This test verifies the logout functionality in the Altex application after successful authentication.

#### Steps:
1. Access the "My Account" tab in the application.
2. Click on the authentication button.
3. Enter the valid email address and password.
4. Click the login button.
5. Scroll to the "Logout" text.
6. Click the logout button.
7. Verify that the authentication option is still present.

code : 
   ```java
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
   ```


### testLoginWithInvalidPass

This test verifies the application's behavior when attempting to log in with an invalid password.

#### Steps:
1. Access the "My Account" tab in the application.
2. Click on the authentication button.
3. Enter the valid email address and an invalid password.
4. Click the login button.
5. Verify that an error message is displayed indicating invalid credentials.

code : 
   ```java
   @Test(dataProvider="getData")
    public void testLoginWithInvalidPassword(HashMap<String ,String> input) throws InterruptedException {
        AccountPage accountPage  =  homePage.clickMyAccountTab();
        accountPage.ClickAutenthButton();
        accountPage.EnterEmail(input.get("ValidEmail"));
        accountPage.EnterPassword(input.get("InvalidPassword"));
        accountPage.ClickLogin();
        accountPage.VerifyErrorMessageIsDisplayed();
    }
   ```

# Search Functionality Tests

## Test 1: Search for Existing Product

#### Steps:
1. Click on the search field.
2. Enter the name of the existing product in the search field.
3. Press the Enter button to perform the search.

code : 
   ```java
    @Test(dataProvider="getData",groups = {"Smoke"})
    public void TestSearchProduct(HashMap<String ,String> input) {
        homePage.clickSearch();
        homePage.typeProductInSearchField(input.get("Product"));
        ProductCatalogue productCatalogue = homePage.pressEnter();
        String ActualResult = productCatalogue.getTitleProductByIndex(0);
        Assert.assertTrue(ActualResult.contains(input.get("Product")));
    }
   ```


#### Verification:
- Verify if the search result contains the searched product.

## Test 2: Search for Non-existent Product

#### Steps:
1. Click on the search field.
2. Enter the name of a non-existent product in the search field.
3. Press the Enter button to perform the search.

code : 
   ```java
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
   ```   

#### Verification:
- Verify if the appropriate error message is displayed.

## Test 3: Verify Home Page Displayed

#### Steps:
1. Check if the home page of the application is displayed.

code : 
   ```java
  @Test(groups = {"Smoke"})
    public void isHomePageDisplayed() {
        boolean isFirstPage = homePage.VerifyDisplayed();
        Assert.assertTrue(isFirstPage, "Not on the first page");
    }
   ```    

#### Verification:
- Verify if the home page is displayed correctly.

## Test 4: Search with Fewer Characters

#### Steps:
1. Click on the search field.
2. Enter fewer characters in the search field.
3. Press the Enter button to perform the search.

code : 
   ```java
     @Test(dataProvider="getData")
    public void testSearchWithFewerCharacters(HashMap<String,String>input) {
        homePage.clickSearch();
        homePage.typeProductInSearchField(input.get("TwoCharacter")); // Fewer characters
        homePage.pressEnter();

        // Verify that the minimum characters message is displayed
        boolean isMessageDisplayed = homePage.VerifyMinimumCharacterMessageEle();
        Assert.assertTrue(isMessageDisplayed, "Minimum characters message is not displayed");
    }
   ```    
   

#### Verification:
- Verify if the message indicating the minimum characters required is displayed.

## Test 5: Search with Empty Input

#### Steps:
1. Click on the search field.
2. Leave the search field empty.
3. Press the Enter button to perform the search.

code : 
   ```java
     @Test()
    public void testSearchWithEmptyInput() {
        homePage.clickSearch();
        homePage.typeProductInSearchField("");
        homePage.pressEnter();

        // Verify that the minimum characters message is displayed
        boolean isMessageDisplayed = homePage.VerifyMinimumCharacterMessageEle();
        Assert.assertTrue(isMessageDisplayed, "Minimum characters message is not displayed");
    }
   ```    

#### Verification:
- Verify if the message indicating the empty search field is displayed.

# Comparison of Two Products Test

This test compares two products and verifies if they are displayed on the comparison page.

## Steps:
1. Click on the search field.
2. Type "Television" into the search field.
3. Press the Enter button to perform the search.
4. Retrieve the titles of the first and second products from the search results.
5. Select the comparison icon for both products.
6. Click the comparison button to view the comparison page.

code : 
   ```java
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
   ```    

## Verification:
- Verify if the title of the first product is visible on the comparison page.
- Verify if the title of the second product is visible on the comparison page.

# Getting Started 📌

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/AdrianPricopie/MobileTestingAppium.git
    ```

2. **Navigate to the project directory:**
    
    ```bash
    cd MobileTestingAppium
    ```
3.**Install maven and set environment variables:**

- you can install from [here](https://maven.apache.org/download.cgi),after you install you need to set environment variables,for that 
  you can see this video on [youtube](https://www.youtube.com/watch?v=3EfvEZ_wThc)
  

4. **Run the Test Suite with HTML reports:**

    ```bash
    BROWSER_AUTOMATION=false mvn test -PRegression
    ```

    or

    ```bash
    BROWSER_AUTOMATION=false mvn test -PRegression
    ```

    After running the tests, you can view the results in the ExtentReports directory. Copy the path from `report.html` and paste it into your browser.

   If you want to run the tests in BrowserStack, follow these steps:

   1. Create an account on the [BrowserStack page](https://www.browserstack.com/).
   2. Go to "App Testing" and "App Automate".
   3. Press upload.
   4. Upload the `atlex.apk` file from my project, which you can find in `src/test/resources/Altex_3.0.0_Apkpure.apk` or [here](https://github.com/AdrianPricopie/MobileTestingAppium/blob/main/src/test/resources/Altex_3.0.0_Apkpure.apk).
   5. Copy the App URL returned when uploading the app to BrowserStack manually.
   6. Press "ACCES KEY".
   7. Copy `userName` key and `accessKey`.
   8. Open `browserstack.yml` file from the project.
   9. Paste the URL in the `app` section.
   10. Paste `userName` key and `accessKey`.
   11. You can run the tests locally with this command:

       ```bash
       BROWSER_AUTOMATION=true mvn test -PRegression
       ```

   12. The report will be generated in your BrowserStack account.

# Reports 

You can access the detailed report on BrowserStack [here](https://app-automate.browserstack.com/dashboard/v2/public-build/VCtkQUNQbHJGT0txNzhDaXJDV29EMm1vRnF1dGpydysxeTZJMXNKdEJNSERBajBZNnNTTDdvb1FucjErQkxLbTVHNzV2YjgzamdmSXpLS3FSZmxtSHc9PS0teS80WHlwWGI3Yms2OHJrVlRoakU5Zz09--c03462a6ed017fd0cb80ee99fa4582a1fc01b0be).

Additionally, here's a snapshot of the HTML report:

![TestReport](https://github.com/AdrianPricopie/MobileTestingAppium/blob/main/Screenshot%202024-05-14%20at%2020.37.31.png)
![TestReport](https://github.com/AdrianPricopie/MobileTestingAppium/blob/main/Screenshot%202024-05-14%20at%2020.43.03.png)

In total, all 36 tests passed across 3 devices, and this report was generated on May 14th.



