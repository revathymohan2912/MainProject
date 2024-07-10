package TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import BaseClass.Base;
import PageClasses.QaLegendAllProjectsPage;
import PageClasses.QaLegendClientsPage;
import PageClasses.QaLegendDashBoard;
import PageClasses.QaLegendEventsPage;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLeavePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagesPage;
import PageClasses.QaLegendNotesPage;
import Utilities.MyRetry;
import Utilities.WaitUtility;

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
	QaLegendClientsPage clientPage;
	QaLegendForgotPassword forgotPasswordPage;
	QaLegendLeavePage leavePage;
	QaLegendAllProjectsPage allProjectsPage;
	
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
		clientPage = new QaLegendClientsPage(driver);
		forgotPasswordPage = new QaLegendForgotPassword(driver);
		leavePage = new QaLegendLeavePage(driver);
		allProjectsPage = new QaLegendAllProjectsPage(driver);
		
		
		
	//	reader = new FileReader("C:\\Users\\AKHIL\\git\\repositoryMainProj\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	//	reader = new FileReader("C:\\Users\\AKHIL\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		
		
		
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void addNotes() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
	//	loginPage.loginToQaLegend("admin@admin.com", "12345678");
	//	System.out.println(path);
		dashBoard.clickOnNotesOption();
		String noteTitle = props.getProperty("notesTitle")+rand.nextInt(10000);
		notesPage.addNotes(noteTitle, props.getProperty("notesDescription"));
		notesPage.searchNotes(noteTitle);
		Assert.assertEquals(notesPage.getNotesTitle(), noteTitle);
		}
	
	@Test
	public void searchNotes() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnNotesOption();
		String noteTitle = props.getProperty("notesTitle")+rand.nextInt(10000);
		notesPage.addNotes(noteTitle, props.getProperty("notesDescription"));
		notesPage.searchNotes(noteTitle);
		Assert.assertEquals(notesPage.getNotesTitle(), noteTitle);
	}
	
	@Test
	public void addEvents() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnEventsOption();
		String eventTitle = props.getProperty("eventsTitle") + rand.nextInt(1000);
		eventPage.addEvents(eventTitle, props.getProperty("eventsDescription"), props.getProperty("eventsLocation"), props.getProperty("eventsStartDate"), props.getProperty("eventsEndDate"));
	}
	
	@Test
	public void addEventForToday() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnEventsOption();
		String eventTitle = props.getProperty("eventsTitle") + rand.nextInt(1000);
		eventPage.addEventCurrentDate(eventTitle, props.getProperty("eventsDescription"));
	}
	
	@Test 
	public void QaLegendLogin() {
		 loginPage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 System.out.println("LOGIN SUCCESSFULL");
	}

	@Test
	public void forgotPasswordLink() {
		forgotPasswordPage.forgotPasswordVerification(props.getProperty("username"));
		Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(), true);
	}
	
	@Test
	public void composeMessage() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnMessagesOption();
		String messageSubject = props.getProperty("messageSubject")+rand.nextInt(10000);
		String message = props.getProperty("message")+rand.nextInt(10000);
		messagePage.composeMessage(props.getProperty("to"), messageSubject, message);
		messagePage.searchForSendMessage(messageSubject);
		Assert.assertEquals(messagePage.getSendMessage(), message);
		}
	@Test
	public void addClients() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnClientsOption();
		String nameClientComapany=props.getProperty("clientCompanyName")+rand.nextInt(10000);
		clientPage.addClient(nameClientComapany);
		clientPage.searchClient(nameClientComapany);
		Assert.assertEquals(clientPage.getClientCompany(), nameClientComapany);
	}
	
	@Test
	public void dashBoard_Checking_MyOpenTasks() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.getMyOpenTasks();
		String no = props.getProperty("No of Open Tasks");
		Assert.assertEquals(dashBoard.getTheNo(), no);
	}
	
	@Test
	public void dashBoard_Checking_OpenProjects() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		System.out.println(dashBoard.getMyOpenProjects());
	}
	
	@Test
	public void checking_Leave_Summary() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnLeaveOption();
		leavePage.leaveSummary(driver);
	}
	
	@Test
	public void addProject() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnProjectsOption();
		dashBoard.clickOnAllProjectsOption();
		String tilte = props.getProperty("projectTitle")+rand.nextInt(10000);
		allProjectsPage.addAProject(driver, tilte, props.getProperty("projectClientName"));
		
	}
	@Test
	public void applyLeave() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnLeaveOption();
		leavePage.applyLeave1();
	}
}
