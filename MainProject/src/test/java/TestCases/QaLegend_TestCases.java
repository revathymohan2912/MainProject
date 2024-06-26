package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import BaseClass.Base;
import PageClasses.QaLegendDashBoard;
import PageClasses.QaLegendEventsPage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagesPage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCases extends Base{
	public WebDriver driver;
	Properties props;	//obj created for property class
	FileReader reader;
	String path = "";
	Random rand;
	QaLegendLoginPage loginPage;
	QaLegendDashBoard dashBoard;
	QaLegendNotesPage notesPage;
	QaLegendEventsPage eventPage;
	QaLegendMessagesPage messagePage;
	
@BeforeMethod
	public void initialization() throws Exception {
		
		driver = browzerInitialization("chrome");
		props = new Properties();		
		path = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.properties";
		reader = new FileReader(path);
		props.load(reader);
		driver.get(props.getProperty("url"));	//value readed from property file
		driver.manage().window().maximize();
		loginPage = new QaLegendLoginPage(driver);
		dashBoard = new QaLegendDashBoard(driver);
		notesPage = new QaLegendNotesPage(driver);
		rand = new Random();
		eventPage = new QaLegendEventsPage(driver);
		messagePage = new QaLegendMessagesPage(driver);
		
	//	reader = new FileReader("C:\\Users\\AKHIL\\git\\repositoryMainProj\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	//	reader = new FileReader("C:\\Users\\AKHIL\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		
		
		
	}
	@Test
	public void addNotes() {
		System.out.println("tc001");
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
	//	loginPage.loginToQaLegend("admin@admin.com", "12345678");
	//	System.out.println(path);
		dashBoard.clickOnNotesOption();
		String noteTitle = props.getProperty("notesTitle")+rand.nextInt(10000);
		notesPage.addNotes(noteTitle, props.getProperty("notesDescription"));
		notesPage.searchNotes(noteTitle, driver);
		Assert.assertEquals(notesPage.getNotesTitle(), noteTitle);
		}
	
	@Test
	public void addEvents() {
		System.out.println("tc002");
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnEventsOption();
		eventPage.addEvents(props.getProperty("eventsTitle"), props.getProperty("eventsDescription"), props.getProperty("eventsLocation"), props.getProperty("eventsStartDate"), props.getProperty("eventsEndDate"));
	}
	
	@Test
	public void composeMessage() {
		System.out.println("tc003");
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnMessagesOption();
		messagePage.composeMessage(props.getProperty("to"), props.getProperty("subject"), props.getProperty("message"));
	}
}
