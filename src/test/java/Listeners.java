import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReporterObject();
    ExtentTest test;
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
    public void onTestFailure(ITestResult result){
        // TODO auto-generated method stub
        test.fail(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context){
        // TODO auto-generated method stub
        extent.flush();
    }
}
