package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendDashBoard {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Events']")
	WebElement eventTab;
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement notesTab;
	@FindBy(xpath = "//span[text()='Messages']")
	WebElement messageTab;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientTab;
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement projectsTab;
	@FindBy(xpath = "//span[text()='Estimates']")
	WebElement estimatesTab;
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement invoicesTab;
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsTab;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveTab;
	
	
	
	
	public QaLegendDashBoard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	public void clickOnNotesOption() {
		PageUtilities.clickOnElement(notesTab);
		
	}

}
