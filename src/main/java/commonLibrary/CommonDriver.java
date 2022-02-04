package commonLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class CommonDriver {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public CommonDriver(String browsertype) {
		if (browsertype.equalsIgnoreCase("chrome")) {

			// Setting up chrome driver path
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\NobleProg\\eclipse-workspace\\LearningSelenium\\driver\\chromedriver.exe");

			// Initializing chrome browser
			driver = new ChromeDriver();

		} else if( browsertype.equalsIgnoreCase("gecko")) {
			
			
			// Setting up firefox driver path
						System.setProperty("webdriver.gecko.driver",
								"C:\\Users\\NobleProg\\eclipse-workspace\\LearningSelenium\\driver\\geckodriver.exe");

						// Initializing firefox browser
						driver = new FirefoxDriver();
			
		} else if(browsertype.equalsIgnoreCase("Edge")) {
			
			// Setting up edge driver path
						System.setProperty("webdriver.edge.driver",
								"C:\\Users\\NobleProg\\eclipse-workspace\\LearningSelenium\\driver\\msedgedriver.exe");

						// Initializing edge browser
						driver = new EdgeDriver();
			
		} else if(browsertype.equalsIgnoreCase("Opera")) {
			// Setting up edge driver path
			System.setProperty("webdriver.opera.driver",
					"C:\\Users\\NobleProg\\eclipse-workspace\\LearningSelenium\\driver\\operadriver.exe");
			// Initializing edge browser
			driver = new OperaDriver();
			
		}
		//PagelLoad Timeout -Time it takes to load any page
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		//Implicit wait -Element direction timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			

		driver.manage().window().maximize();

	}

	public void navigatetoURL(String url) {
		driver.get(url);

	}

	public void closeBrowser() {
		driver.quit();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
