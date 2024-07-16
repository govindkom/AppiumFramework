package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenrReporteNG {
	static ExtentReports extent;
	 
	 
	public static ExtentReports getReporterObject() {
		
String filepath = System.getProperty("user.dir") + "//reports//index.html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
        reporter.config().setReportName("webAutomationResult");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "govind");
        
        return extent;
	}

}
