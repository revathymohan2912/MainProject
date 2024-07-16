package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DateUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendLeavePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='Apply leave']")
	WebElement applyLeaveTab;
	@FindBy(xpath = "//div[@class=' col-md-9']//div")
	WebElement leaveType;
	@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
	WebElement selectLeaveType;
	@FindBy(xpath = "//a[text()='Summary']")
	WebElement summaryTab;
	@FindBy(xpath = "//input[@name='single_date']")
	WebElement dateTab;
	@FindBy(xpath = "//textarea[@name='reason']")
	WebElement reason;
	@FindBy(xpath = "//button[text()=' Apply leave']")
	WebElement applyLeaveButton;
	
	
	
	@FindBy(xpath = "//a[text()=' Assign leave']")
	WebElement assignLeave;
	@FindBy(xpath = "(//form[@id='leave-form']//span)[1]")
	WebElement teamMember;
	@FindBy(xpath = "(//div[@id='select2-drop'])//input")
	WebElement searchTeamMember;
	@FindBy(xpath = "(//span[@class='select2-chosen'])[3]")
	WebElement leaveTypeAssign;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement searchLeaveType;
	@FindBy(xpath = "//div[text()='Casual Leave ']")
	WebElement casual;
	@FindBy(xpath = "//input[@id='single_date']")
	WebElement dateField;
	@FindBy(xpath = "//textarea[@name='reason']")
	WebElement reasonAssign;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement assignLeaveButton;
	@FindBy(xpath = "(//div[@class='col-md-10 custom-toolbar']//input)[2]")
	WebElement searchLeave;
	@FindBy(xpath = "//tr[@class='odd']//a")
	WebElement leaveSummary;
	@FindBy(xpath = "(//span[text()='Excel'])[2]")
	WebElement excelClick;
	
	public QaLegendLeavePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void leaveSummary(WebDriver driver) {
		WaitUtility.waitForAnElementToBeVisible(driver, summaryTab);
		PageUtilities.clickOnElement(summaryTab);
	}
	
	public void applyLeave1(String leaveReason) throws InterruptedException {
	
		PageUtilities.clickOnElement(applyLeaveTab);
		PageUtilities.clickOnElement(leaveType);
		PageUtilities.clickOnElement(selectLeaveType);
		PageUtilities.enterText(dateTab, DateUtility.getCurrentDate());
		PageUtilities.enterText(reason, leaveReason);
		PageUtilities.clickOnElement(applyLeaveButton);
	}
	
	public void assignLeave(String teamMemberName, String leaveType, String reason) {
		PageUtilities.clickOnElement(assignLeave);
		PageUtilities.clickOnElement(teamMember);
		PageUtilities.clickOnElement(searchTeamMember);
		PageUtilities.enterText(searchTeamMember, teamMemberName);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(leaveTypeAssign);
		PageUtilities.clickOnElement(casual);
		PageUtilities.enterText(dateField, DateUtility.getCurrentDate());
		PageUtilities.enterText(reasonAssign, reason);
		PageUtilities.clickOnElement(assignLeaveButton);
	}
	
	public void searchLeave(String name) {
		WaitUtility.waitForAnElementToBeVisible(driver, summaryTab);
		PageUtilities.clickOnElement(summaryTab);
		PageUtilities.clickOnElement(searchLeave);
		PageUtilities.enterText(searchLeave, name);
		
	}	
	public String getLeave() {
		String teammemb = PageUtilities.getElementText(leaveSummary);
		return teammemb;
	}
	public void getExcel() {
		PageUtilities.clickOnElement(excelClick);
	}
}
