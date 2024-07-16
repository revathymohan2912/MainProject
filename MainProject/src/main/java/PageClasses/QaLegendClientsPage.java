package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendClientsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement addClientButton;
	@FindBy(xpath = "//input[@name='company_name']")
	WebElement companyNameBox;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement clientSaveButton;
	@FindBy(xpath = "//div[@id='client-table_filter']//input")
	WebElement clientSearch;
	@FindBy(xpath = "//table[@id='client-table']//a")
	WebElement clientSearchResult;
	
	
	
	public QaLegendClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}





	public void addClient(String companyname) {
		WaitUtility.waitForAnElementToBeVisible(driver, addClientButton);
		PageUtilities.clickOnElement(addClientButton);
		PageUtilities.enterText(companyNameBox, companyname);
		PageUtilities.clickOnElement(clientSaveButton);
	}
	public void searchClient(String searchname) throws InterruptedException {
		Thread.sleep(5000);
		//WaitUtility.waitForAnElementToBeVisible(driver, clientSearch);
		PageUtilities.clickOnElement(clientSearch);
		PageUtilities.enterText(clientSearch, searchname);
	}
	public String getClientCompany() {
		String getCompanyName=PageUtilities.getElementText(clientSearchResult);
		return getCompanyName;
	}
	

}
