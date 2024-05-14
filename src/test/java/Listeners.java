import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends  AppiumUtils implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReporterObject();
    ExtentTest test;
    AppiumDriver driver;
    @Override
    public void onTestStart(ITestResult result){
        // TODO auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        // TODO auto-generated method stub
        //screenshot code
        test.log(Status.PASS,"Test Passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        // TODO auto-generated method stub
        test.fail(result.getThrowable());
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e1) {
            // TODO auto-generated catch block
            e1.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(getSccreenshotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
        } catch (IOException e) {
            // TODO auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context){
        // TODO auto-generated method stub
        extent.flush();
    }
}
