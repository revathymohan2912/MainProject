package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendNotesPage {
	WebDriver driver ;
	@FindBy(className = "btn btn-default'")
	WebElement addNotesButton;
	@FindBy(xpath = "//input[@class='form-control notepad-title']")
	WebElement titleBoxField;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement descriptionBoxField;
	@FindBy(name = "labels")
	WebElement labelsBoxField;
	
	
	
	public QaLegendNotesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void addNotes(String title, String description) {
		PageUtilities.clickOnElement(addNotesButton);
		PageUtilities.enterText(titleBoxField, description);
	}

}
