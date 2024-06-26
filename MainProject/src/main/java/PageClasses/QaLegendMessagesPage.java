package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendMessagesPage {
	
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Compose']")
	WebElement composeTab;
	@FindBy(xpath = "(//input[@class='select2-input'])[2]")
	WebElement toBox;
	@FindBy(xpath = "//input[@name='subject']")
	WebElement subjectBox;
	@FindBy(xpath = "//button[text()=' Send']")
	WebElement sendButton;
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement writeAmessage;
	
	
	
	
	public QaLegendMessagesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void composeMessage(String toField, String subjectField, String messageField) {
		PageUtilities.clickOnElement(composeTab);
		PageUtilities.clickOnElement(toBox);
		PageUtilities.enterText(toBox, toField);
		PageUtilities.clickOnElement(subjectBox);
		PageUtilities.enterText(subjectBox, subjectField);
		PageUtilities.clickOnElement(writeAmessage);
		PageUtilities.enterText(writeAmessage, messageField);
		PageUtilities.clickOnElement(sendButton);
		
	}
	

}
