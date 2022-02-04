package commonLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownControl {
	public void selectViaVisibleText(WebElement element, String visibLeText) {
		Select select= new Select(element);
		select.selectByVisibleText(visibLeText);
		
	}

}
