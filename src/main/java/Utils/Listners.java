package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listners extends AppiumUtils_And_IOS implements ITestListener{

	public Listners(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// here yoyu can add unimplementred method
	ExtentTest test;
	
	ExtentReports extent =ExtenrReporteNG.getReporterObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
	}
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	//	test.addScreenCaptureFromPath(null, null)
		
		try {
			driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	
	
}
