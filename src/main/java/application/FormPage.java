package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonLibrary.DropDownControl;
import commonLibrary.ElementControl;
import commonLibrary.WaitUtils;

public class FormPage {

	WebDriver driver;
	@FindBy(id = "wpforms-49-field_1")
	private WebElement fistnamefield;

	@FindBy(id = "wpforms-49-field_1-last")
	private WebElement lastnamefield;

	@FindBy(id = "wpforms-49-field_2")
	private WebElement emailfield;

	@FindBy(id = "wpforms-49-field_4")
	private WebElement phonenumberfield;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement femalecheckbox;

	@FindBy(id = "wpforms-49-field_5")
	private WebElement courseDropDownField;

	@FindBy(id = "wpforms-submit-49")
	private WebElement sunmitButtonField;

	@FindBy(xpath = "//div[@id='wpforms-confirmation-49']/p")
	private WebElement confirmationMessageBoxFiel;
	
	ElementControl elementControl;
	DropDownControl dropDownControl;

	public FormPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		elementControl=new ElementControl();
		dropDownControl=new DropDownControl();
	}

	public String fillFormElement(String firstname, String lastname, String course) {
		
        WaitUtils.waitTillElementVisible(driver, fistnamefield, 10);
       
        
		elementControl.sendText(fistnamefield, firstname);
		
		elementControl.sendText(lastnamefield, lastname);
		elementControl.sendText(emailfield, "dominique.ouedraogo@adesso.ch");
		elementControl.sendText(phonenumberfield, "45643785457");
		
		
	    
		elementControl.clickElement(femalecheckbox);
		
		dropDownControl.selectViaVisibleText(courseDropDownField, course);
		
		elementControl.clickElement(sunmitButtonField);

		String confirmationMessage = elementControl.getText(confirmationMessageBoxFiel);
		return confirmationMessage;

	}

}
