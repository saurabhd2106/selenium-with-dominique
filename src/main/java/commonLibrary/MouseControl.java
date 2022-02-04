package commonLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseControl {
	
	WebDriver driver;
	
	public MouseControl(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void moveToElement(WebElement element) {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(element).build().perform();
		
	}

}
