package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import resources.extentReporterNG;

public class Listeners  extends base implements ITestListener{

	ExtentReports extent = extentReporterNG.getExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure (ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		extenttest.get().fail(result.getThrowable());
		
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
		
		} 
		
		
		try {
			extenttest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodname,driver), result.getMethod().getMethodName());
			getScreenshotPath(testmethodname,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
