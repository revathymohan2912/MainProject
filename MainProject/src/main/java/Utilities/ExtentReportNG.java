package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\test-output\\report.html";
	//	String path = "C:\\Users\\AKHIL\\git\\repositoryMainProj\\MainProject\\test-output\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Revathy");
		return extent;
	}
}