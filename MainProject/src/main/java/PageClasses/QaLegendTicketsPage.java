package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendTicketsPage {
	
	WebDriver driver;
	@FindBy(xpath = "(//a[@title='Add ticket'])[2]")
	WebElement addTicketButton;
	@FindBy(id = "title")
	WebElement ticketTitle;
	@FindBy(xpath = "//div[@id='s2id_client_id']")
	WebElement clientDropDown;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement clientSearch;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement descriptionField;
	@FindBy(xpath = "(//span[@class='select2-chosen'])[6]")
	WebElement assignDropDown;
	@FindBy(xpath = "(//div[@class='select2-search']//input)[5]")
	WebElement assignSearch;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@id='ticket-table_filter']//input")
	WebElement searchTicket;
	@FindBy(xpath = "(//tr[@class='odd']//a)[2]")
	WebElement searchResultTitle;
	
	

	public QaLegendTicketsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addTicket(String title, String client, String description) {
		PageUtilities.clickOnElement(addTicketButton);
		PageUtilities.enterText(ticketTitle, title);
		PageUtilities.clickOnElement(clientDropDown);
		PageUtilities.enterText(clientSearch, client);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(descriptionField, description);
		PageUtilities.clickOnElement(saveButton);
	}
	
	public void searchTicket(String title) throws InterruptedException {
		Thread.sleep(5000);
	//	WaitUtility.waitForAnElementToBeVisible(driver, searchTicket);
		PageUtilities.clickUsingJavaScriptExecutor(searchTicket, driver);
		PageUtilities.enterText(searchTicket, title);
	}
	
	public String getTicket() {
		String getTitle = PageUtilities.getElementText(searchResultTitle);
		return getTitle;
	}

}
