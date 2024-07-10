package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.PageUtilities;

public class QaLegendLeavePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Apply leave']")
	WebElement applyLeaveTab;
	@FindBy(xpath = "//span[@id='select2-chosen-13']")
	WebElement leaveType;
	@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
	WebElement selectLeaveType;
	@FindBy(xpath = "//a[text()='Summary']")
	WebElement summaryTab;
	
	
	
	
	public QaLegendLeavePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void leaveSummary(WebDriver driver) {
		PageUtilities.clickUsingJavaScriptExecutor(summaryTab, driver);
	}
	
	public void applyLeave1() throws InterruptedException {
		
	//	PageUtilities.clickUsingJavaScriptExecutor(applyLeaveTab, driver);
		PageUtilities.clickOnElement(applyLeaveTab);
		/*
		 * PageUtilities.clickOnElement(leaveType);
		 * PageUtilities.clickOnElement(selectLeaveType);
		 */
	}
	
	
}
