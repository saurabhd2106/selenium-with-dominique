package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
	private WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public void DragAndDrop() {
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);

		action.dragAndDrop(source, destination).build().perform();

	}
}
