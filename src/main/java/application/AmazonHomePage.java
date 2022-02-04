package application;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibrary.DropDownControl;
import commonLibrary.ElementControl;
import commonLibrary.MouseControl;

public class AmazonHomePage {

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdown;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchbox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@data-component-type=\"s-search-result\"]")
	private List<WebElement> allProducts;

	ElementControl elementControl;
	DropDownControl dropDownControl;
	MouseControl mouseControl;

	public AmazonHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		elementControl = new ElementControl();

		dropDownControl = new DropDownControl();
		
		mouseControl = new MouseControl(driver);
	}

	public void searchProduct(String productName, String category) {

		dropDownControl.selectViaVisibleText(searchDropdown, category);

		elementControl.sendText(searchbox, productName);

		elementControl.clickElement(searchButton);

	}

	public void getAllProducts() {
		
		for(WebElement element: allProducts) {
			
			mouseControl.moveToElement(element);
			System.out.println(elementControl.getText(element));
			
			System.out.println("-----------------------");
		}

	}

}
