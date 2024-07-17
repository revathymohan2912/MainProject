package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendExpensePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()=' Add expense']")
	WebElement addExpenseButton;
	@FindBy(id = "amount")
	WebElement amountField;
	@FindBy(id = "title")
	WebElement titleField;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='dataTables_filter']//input")
	WebElement searchBox;
	@FindBy(xpath = "(//tr[@class='odd']//td)[3]")
	WebElement searchResult;
	@FindBy(xpath = "(//tr[@class='odd']//td)[3]")
	WebElement searchExpenseTitle;
	
	

	public QaLegendExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addNewExpense(String amount, String title) {
		PageUtilities.clickOnElement(addExpenseButton);
		PageUtilities.clickOnElement(amountField);
		PageUtilities.enterText(amountField, amount);
		PageUtilities.enterText(titleField, title);
		PageUtilities.clickOnElement(saveButton);
	}
	
	public void searchExpense(String searchTitle) throws InterruptedException {
		Thread.sleep(5000);
	//	WaitUtility.waitForAnElementToBeVisible(driver, searchBox);
		PageUtilities.clickUsingJavaScriptExecutor(searchBox, driver);
		PageUtilities.enterText(searchBox, searchTitle);
	}
	public String getExpense() {
		String getTitle = PageUtilities.getElementText(searchExpenseTitle);
		return getTitle;
	}

}
