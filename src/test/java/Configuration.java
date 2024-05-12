
import PageObjects.android.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Configuration extends AppiumUtils  {

    public HomePage homePage;
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeMethod
    public void ConfigureAppium() throws IOException{
        //start server appium
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");

        prop.load(fis);

        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        String DeviceName = prop.getProperty("AndroidDeviceName");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));


        //configure app
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(DeviceName); //emulator
        options.setApp("/Users/adrianpricopie/IdeaProjects/AppiumFrameworkDesign/src/test/resources/Altex_3.0.0_Apkpure.apk");
        driver = new AndroidDriver(service.getUrl(),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         //click cookies
        driver.findElement(By.xpath("(//android.view.View[@resource-id='ro.altex.mobile:id/ucButtonForeground'])[1]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sari peste']")).click();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}