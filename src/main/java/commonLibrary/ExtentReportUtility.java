package commonLibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	ExtentReports extentReport;
	ExtentSparkReporter park;
	ExtentTest extentTest;

	public ExtentReportUtility(String reportFileName) {
		extentReport = new ExtentReports();
		park = new ExtentSparkReporter(reportFileName);
		extentReport.attachReporter(park);

	}
	public void createTestCase(String testname) {
		extentTest=extentReport.createTest(testname);
	}
	public void addLogs(String status, String logmessage) {
		if (status.equalsIgnoreCase("info")) {
			extentTest.log(Status.INFO, logmessage);
			
		}else if (status.equalsIgnoreCase("warning")){
			extentTest.log(Status.WARNING, logmessage);
			
		}else if (status.equalsIgnoreCase("pass")) {
			extentTest.log(Status.PASS, logmessage);
			
		}else if (status.equalsIgnoreCase("fail")) {
			extentTest.log(Status.FAIL, logmessage);
		}
	}
	public void flushReport() {
		extentReport.flush();
	}
}