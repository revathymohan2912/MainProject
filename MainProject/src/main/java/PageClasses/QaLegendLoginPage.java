package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import net.bytebuddy.asm.Advice.This;

public class QaLegendLoginPage {
	WebDriver driver;
	@FindBy(id = "email")
	WebElement usernameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement siginButton;
	
	
	public QaLegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void loginToQaLegend(String username, String password) {
		PageUtilities.enterText(usernameField, username);
		PageUtilities.enterText(passwordField, password);
		PageUtilities.clickOnElement(siginButton);
	}
	
}
