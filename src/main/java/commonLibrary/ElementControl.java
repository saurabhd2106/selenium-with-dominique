package commonLibrary;

import org.openqa.selenium.WebElement;

public class ElementControl {

	public void sendText(WebElement element, String textToWrite) {
		element.sendKeys(textToWrite);

	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

}