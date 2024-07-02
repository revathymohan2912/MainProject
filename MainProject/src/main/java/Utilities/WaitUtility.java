package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long EXPLICIT_WAIT = 5;
	public static void waitForElementToBeCLicked(WebDriver driver, WebElement target) {
	WebDriverWait wait	= new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	
	public static void waitForElementTextToBePresent(WebDriver driver, WebElement target, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, text));
	}
	public static void waitForAnElementToBeVisible(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}

	public static void waitForAnAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForElementTextToBe(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	
	}
}
