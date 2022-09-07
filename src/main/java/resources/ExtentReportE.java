package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportE  {
	
	static ExtentReports extent;

	

	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Ecommerce  Test Automation Results");
		
		reporter.config().setDocumentTitle("Ecommerce Project Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Jinto Jose");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Os","Windows 10");
		return extent;	
	
}}


