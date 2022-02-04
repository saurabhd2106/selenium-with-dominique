package commonLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitTillElementVisible(WebDriver driver,WebElement element, int duration) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
	
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitTillElementClickable(WebDriver driver,WebElement element, int duration) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
}
