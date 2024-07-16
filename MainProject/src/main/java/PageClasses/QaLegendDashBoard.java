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
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement allProjectsTab;
	@FindBy(xpath = "//span[text()='Estimates']")
	WebElement estimatesTab;
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement invoicesTab;
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsTab;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveTab;
	@FindBy(xpath = "//span[text()='Finance']")
	WebElement financeTab;
	@FindBy(xpath = "//span[text()='Expenses']")
	WebElement expensesTab;
	@FindBy(xpath = "//span[text()='Tickets']")
	WebElement ticketsTab;
	
	
	@FindBy(xpath = "//div[@class='widget-details']//h1")
	WebElement noOfMyOpenTasks;
	@FindBy(xpath = "(//div[@class='panel-body ']//h1)[4]")
	WebElement noOfMyOpenProjects;
	
	
	
	
	
	public QaLegendDashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNotesOption() {
		PageUtilities.clickOnElement(notesTab);
		
	}
	public void clickOnEventsOption() {
		PageUtilities.clickOnElement(eventTab);
	}
	public void clickOnClientsOption() {
		PageUtilities.clickOnElement(clientTab);
	}
	public void clickOnMessagesOption() {
		PageUtilities.clickOnElement(messageTab);
	}
	
	public void clickOnLeaveOption() {
		PageUtilities.clickOnElement(leaveTab);
	}
	
	public void getMyOpenTasks() {
		PageUtilities.getElementText(noOfMyOpenTasks);
	}
	
	public String getTheNo() {
		String no = PageUtilities.getElementText(noOfMyOpenTasks);
		return no;
	}
	
	public String getMyOpenProjects() {
		String openProj = PageUtilities.getElementText(noOfMyOpenProjects);
		return openProj;
	}
	
	public void clickOnProjectsOption() {
		PageUtilities.clickOnElement(projectsTab);
	}
	
	public void clickOnAllProjectsOption() {
		PageUtilities.clickOnElement(allProjectsTab);
	}
	
	public void clickOnFinanceOption() {
		PageUtilities.clickOnElement(financeTab);
	}
	
	public void clickOnExpenses() {
		PageUtilities.clickOnElement(expensesTab);
	}
	
	public void clickOnTickets() {
		PageUtilities.clickOnElement(ticketsTab);
	}
}
