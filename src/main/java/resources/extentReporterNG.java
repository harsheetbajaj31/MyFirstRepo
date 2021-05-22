package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getExtentReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Test Report");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Harsheet Bajaj");
		
		return extent;
		
	}

}
