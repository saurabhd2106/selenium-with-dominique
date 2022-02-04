package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import application.DragAndDropPage;
import application.FormPage;
import commonLibrary.CommonDriver;
import commonLibrary.DateTimeUtils;
import commonLibrary.ExtentReportUtility;
import commonLibrary.ScreenshotUtils;
import testData.DataGenerator;

public class WorkingWithChrome {
	WebDriver driver;

	CommonDriver cmnDriver;

	FormPage formPage;

	DragAndDropPage dragAndDropPage;

	ExtentReportUtility reportUtils;
	String currentWorkDirectory;

	String executionStartTime;
	String reportFilename;

	@BeforeClass
	public void preSetup() {
		currentWorkDirectory = System.getProperty("user.dir");

		executionStartTime = DateTimeUtils.getCurrentDateAndTime();

		reportFilename = currentWorkDirectory + "/Reports/" + executionStartTime + "/testReport.html";

		reportUtils = new ExtentReportUtility(reportFilename);
	}

	@AfterClass
	public void postCleanup() {
		reportUtils.flushReport();
	}

	@Parameters("browserType")
	@BeforeMethod(alwaysRun = true)
	public void setup(String browserType) {

		reportUtils.createTestCase("Setup- Test Automation prequisite");

		cmnDriver = new CommonDriver(browserType);

		reportUtils.addLogs("info", "Initialize the browser driver " + browserType);
		driver = cmnDriver.getDriver();

		formPage = new FormPage(driver);

		dragAndDropPage = new DragAndDropPage(driver);

		reportUtils.addLogs("info", "Initialize all the page ");

	}

	@AfterMethod(alwaysRun = true)
	public void cleanUp(ITestResult testResults) throws Exception {

		String screenshotFilename = currentWorkDirectory + "/screenshots/" + testResults.getName() + "-"
				+ DateTimeUtils.getCurrentDateAndTime() + ".jpeg";

		if (testResults.getStatus() == ITestResult.SUCCESS) {
			reportUtils.addLogs("Pass", "All tests Pass");
		} else if (testResults.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtils.takeScreenshot(driver, screenshotFilename);

			reportUtils.addLogs("fail", "one or more fails");

		}

		else {
			reportUtils.addLogs("skip", "test case skipped");
		}

		reportUtils.createTestCase("Clean Up - Close browser");
		// This close the browser
		cmnDriver.closeBrowser();

		reportUtils.addLogs("info", "Closing the browser");

	}

	@Test(priority = 1000, groups = { "sanity", "smoke" })
	public void verifyTitleOfThePage() {

		reportUtils.createTestCase("TC#3 - Verify title of the page ");

		// Navigating to a url
		driver.get("http://test.qatechhub.com/");

		String actualTitle = cmnDriver.getTitle();

		// Comparing expected and actual title
		String expectedTitle = "Test QA Tech Hub – Learning By Doing is the best way to learn!!!!";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 100, dataProvider = "getData", dataProviderClass = DataGenerator.class)
	public void formElement(String firtname, String lastname, String course) {

		String url = "https://test.qatechhub.com/form-elements";

		reportUtils.createTestCase("TC#2 - Verify form page ");

		cmnDriver.navigatetoURL(url);

		reportUtils.addLogs("info", "Navigating to the URL" + url);

		String expectedMessage = "You have successfully filled in the form!";

		String confirmationMessage = formPage.fillFormElement(firtname, lastname, course);

		Assert.assertEquals(confirmationMessage, expectedMessage);
	}

	@Test(priority = 100)
	public void verifyDragAndDrop() {

		reportUtils.createTestCase("TC#1 - Verify Drag and Drop");

		cmnDriver.navigatetoURL("http://test.qatechhub.com/drag-and-drop");
		dragAndDropPage.DragAndDrop();
	}
}
