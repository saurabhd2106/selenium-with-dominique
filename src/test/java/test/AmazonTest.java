package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import application.AmazonHomePage;

public class AmazonTest extends BaseTest {

	AmazonHomePage amazonHomepage;


	@BeforeMethod(alwaysRun = true)
	public void setup() {

		amazonHomepage = new AmazonHomePage(driver);

	}

	@Test (priority=1)
	public void verifySearchProoduct() {

		cmnDriver.navigatetoURL("https://amazon.com");

		amazonHomepage.searchProduct("Apple Watch", "Electronics");
		
		amazonHomepage.getAllProducts();

	}

}
