package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendForgotPassword {
	
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgotpasswordlink;
	@FindBy(id = "email")
	WebElement enterEmail;
	@FindBy(xpath = "//button[text()='Send']")
	WebElement sendButton;
	@FindBy(xpath = "//div[text()='Email sent!']")
	WebElement emailSentAlert;
	
	
	
	public QaLegendForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void forgotPasswordVerification(String email) {
		PageUtilities.clickOnElement(forgotpasswordlink);
		PageUtilities.enterText(enterEmail, email);
		PageUtilities.clickOnElement(sendButton);
	}
	
	public Boolean getForgotPasswordStatus() {
		boolean forgotpasssuccessmessage = PageUtilities.isElementDisplayed(emailSentAlert);
		return forgotpasssuccessmessage;
	}


}
