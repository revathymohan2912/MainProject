package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendNotesPage {
	WebDriver driver ;
	@FindBy(xpath = "//div[@class='title-button-group']/a")
	WebElement addNotesButton;
	@FindBy(xpath = "//input[@class='form-control notepad-title']")
	WebElement titleBoxField;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement descriptionBoxField;
	@FindBy(name = "labels")
	WebElement labelsBoxField;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@id='note-table_filter']//input")
	WebElement notesSearchBox;
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement searchTitle;
	
	
	public QaLegendNotesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void addNotes(String title, String description) {
		PageUtilities.clickOnElement(addNotesButton);
		PageUtilities.enterText(titleBoxField, title);
		PageUtilities.enterText(descriptionBoxField, description);
		PageUtilities.clickOnElement(saveButton);
	}
	public void searchNotes(String title, WebDriver driver) {
	//	PageUtilities.clickOnElement(notesSearchBox);
		PageUtilities.clickUsingJavaScriptExecutor(notesSearchBox, driver);
		PageUtilities.enterText(notesSearchBox, title);
	}
	
	public String getNotesTitle() {
		String getTitle = PageUtilities.getElementText(searchTitle);
		return getTitle;
	}

}
