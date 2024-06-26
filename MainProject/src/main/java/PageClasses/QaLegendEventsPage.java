package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendEventsPage {
	
	WebDriver driver;
	@FindBy(xpath = "//a[text()=' Add event']")
	WebElement addEventButton;
	@FindBy(xpath = "//input[@name='title']")
	WebElement titleBoxEvents;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement descriptionBoxEvents;
	@FindBy(xpath = "//input[@name='location']")
	WebElement locationBoxEvents;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButtonEvents;
	@FindBy(xpath = "//input[@name='start_date']")
	WebElement startDateBox;
	@FindBy(xpath = "//input[@name='end_date']")
	WebElement endDateBox;
	@FindBy(xpath = "//input[@name='start_time']")
	WebElement startTime;
	@FindBy(xpath = "//input[@name='end_time']")
	WebElement endTime;
	
	
	

	public QaLegendEventsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addEvents(String tittle, String description, String location, String startDate, String endDate) {
		PageUtilities.clickOnElement(addEventButton);
		PageUtilities.enterText(titleBoxEvents, tittle);
		PageUtilities.enterText(descriptionBoxEvents, description);
		PageUtilities.enterText(locationBoxEvents, location);
	//	PageUtilities.clickOnElement(startDateBox);
		PageUtilities.enterText(startDateBox, startDate);
		PageUtilities.clickOnElement(startTime);
	//	PageUtilities.clickOnElement(endDateBox);
		PageUtilities.enterText(endDateBox, endDate);
		PageUtilities.clickOnElement(endTime);
		PageUtilities.enterText(locationBoxEvents, location);
		PageUtilities.clickOnElement(saveButtonEvents);
	}

}
