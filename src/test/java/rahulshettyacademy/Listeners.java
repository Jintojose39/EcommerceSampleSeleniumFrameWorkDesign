package rahulshettyacademy;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import resources.ExtentReportE;
import resources.base;

public class Listeners extends base implements  ITestListener {
	
	ExtentTest test;
	ExtentReports extent=ExtentReportE.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		 
		}catch(Exception e) {
			
		}
		try {
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		extentTest.get().log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case failed due to below issues ",ExtentColor.RED));
		test.fail(result.getThrowable());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
		//extentTest.get().log(Status.SKIP, "Test Skipped");
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
}
