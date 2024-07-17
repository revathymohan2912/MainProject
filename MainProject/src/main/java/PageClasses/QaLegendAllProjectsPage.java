package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendAllProjectsPage {
	WebDriver driver;
//	@FindBy(xpath = "//a[@class='btn btn-default']")
	@FindBy(xpath = "//a[text()=' Add project']")
	WebElement addProjectButton;
	@FindBy(xpath = "//input[@id=\"title\"]")
	WebElement projecTitle;
	@FindBy(xpath = "//div[@class='form-group']//a")
	WebElement clientDropDown;
	@FindBy(xpath = "//input[@id='s2id_autogen6_search']")
	WebElement clientSearchTab;
	@FindBy(xpath = "//ul[@class='select2-results']//span")
	WebElement selectClient;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement saveProject;
	
	
	

	public QaLegendAllProjectsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addAProject(WebDriver driver, String title ,String client) {
		PageUtilities.clickUsingJavaScriptExecutor(addProjectButton, driver);
		PageUtilities.enterText(projecTitle, title);
		PageUtilities.clickOnElement(clientDropDown);
		PageUtilities.enterText(clientSearchTab, client);	
		PageUtilities.clickOnElement(selectClient);
		PageUtilities.clickOnElement(saveProject);
	}

}
