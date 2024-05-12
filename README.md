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
- Test Devices:
  - Samsung S22
  - Google Pixel 6
- Android 12: Operating system used on the test devices.

## Project Structure

1. **src/main/java/PageObjects**:The Page Object Model (POM) is a design pattern that helps in creating reusable and maintainable code by representing each web page as a separate class.
2. **src/main/java/Utils/AndroidActions**:This directory likely contains utility classes or methods related to performing actions specific to Android devices in a mobile automation project.to perform actions such as tapping, swiping.
3. **src/main/java/Resources/data.properties**:The data.properties file stores various configuration parameters in a key-value pair format.
4. **src/test/java/Resources/Altex_3.0.0_Apkpure.apk**:In the context of mobile application testing, the APK file serves as the deployment package for the Altex application Test automation frameworks can use this file to install and execute tests on Android devices.
3. **src/ExtentReport/**:ExtentReports is a popular reporting library in the Java ecosystem used to generate interactive and detailed reports for test automation executions. This directory serves as a centralized location for storing these report
4. **src/test/TestData/eCommerce.json**:In the context of software testing, test data files like "eCommerce.json" are used to provide input data for test cases, define expected outcomes, or configure test environments.
5. **src/test/java/AppiumUtils**: These utilities can be useful for loading data from a JSON file during tests and for starting and managing a local Appium server for testing. Using such utilities helps maintain modular, understandable, and maintainable code in automation testing projects.
6. **src/test/java/Configuration**: the Configuration class is responsible for setting up and configuring the Appium environment, initializing the Android driver, and performing cleanup tasks after test execution. This class plays a crucial role in the test automation framework for testing the Altex application on Android devices.
7. **src/test/java/Listeners**: Listeners class serves as a listener for TestNG test events and is responsible for generating Extent reports with detailed test execution results. It captures test start, success, and failure events and logs them appropriately in the Extent report. This class plays a vital role in providing comprehensive test reports for analyzing test execution outcomes.
8. **src/test/java/ExtentReporterNG**:ExtentReporterNG class facilitates the creation and configuration of Extent reports by providing a method to obtain an instance of the ExtentReports object with the necessary settings. This class is integral to generating comprehensive and visually appealing test reports for analyzing test execution results.







