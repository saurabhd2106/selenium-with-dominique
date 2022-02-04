package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commonLibrary.CommonDriver;

public class BaseTest {

	WebDriver driver;

	CommonDriver cmnDriver;

	@Parameters("browserType")
	@BeforeClass(alwaysRun = true)
	public void preSetup(String browserType) {

		cmnDriver = new CommonDriver(browserType);

		driver = cmnDriver.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void postCleanup() {
		
		cmnDriver.closeBrowser();

	}

}
