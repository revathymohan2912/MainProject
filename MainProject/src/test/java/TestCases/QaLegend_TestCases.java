package TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import BaseClass.Base;
import PageClasses.QaLegendAllProjectsPage;
import PageClasses.QaLegendClientsPage;
import PageClasses.QaLegendDashBoard;
import PageClasses.QaLegendEventsPage;
import PageClasses.QaLegendExpensePage;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLeavePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagesPage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendTicketsPage;
import Utilities.ExcelUtility;
import Utilities.MyRetry;
import Utilities.WaitUtility;

public class QaLegend_TestCases extends Base{
	public WebDriver driver;
	Properties props;	
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
	QaLegendExpensePage expensePage;
	QaLegendTicketsPage ticketsPage;
	
@BeforeMethod
	public void initialization() throws Exception {
		
		driver = browzerInitialization("chrome");
		props = new Properties();		
		path = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.properties";
		reader = new FileReader(path);
		props.load(reader);
		driver.get(props.getProperty("url"));
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
		expensePage = new QaLegendExpensePage(driver);
		ticketsPage = new QaLegendTicketsPage(driver);
	}


	@Test (retryAnalyzer = MyRetry.class, groups = {"RegressionTest"})
	public void QaLegendLogin() {
		 loginPage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 System.out.println("LOGIN SUCCESSFULL");
	}
	
	@Test(retryAnalyzer = MyRetry.class, groups = {"SmokeTest"})
	public void forgotPasswordLink() {
		forgotPasswordPage.forgotPasswordVerification(props.getProperty("username"));
		Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(), true);
	}
	

	@Test(retryAnalyzer = MyRetry.class, groups = {"RegressionTest"})
	public void addNotes() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnNotesOption();
		String noteTitle = props.getProperty("notesTitle")+rand.nextInt(10000);
		notesPage.addNotes(noteTitle, props.getProperty("notesDescription"));
		notesPage.searchNotes(noteTitle);
		Assert.assertEquals(notesPage.getNotesTitle(), noteTitle);
		}

	
	
	@Test(retryAnalyzer = MyRetry.class, groups = {"SmokeTest"})
	public void searchNotes() throws InterruptedException {
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
	
	@Test(retryAnalyzer = MyRetry.class)
	public void composeMessage() throws IOException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnMessagesOption();
		String messageSubject = ExcelUtility.getString(1, 0, props.getProperty("excelPath"), "ComposeMessage")+rand.nextInt(10000);
		String message = ExcelUtility.getString(1, 1, props.getProperty("excelPath"), "ComposeMessage")+rand.nextInt(10000);
		messagePage.composeMessage(props.getProperty("to"), messageSubject, message);
		messagePage.searchForSendMessage(messageSubject);
		Assert.assertEquals(messagePage.getSendMessage(), message);
		}
	@Test
	public void addClients() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnClientsOption();
		String nameClientComapany=props.getProperty("clientCompanyName")+rand.nextInt(10000);
		clientPage.addClient(nameClientComapany);
		clientPage.searchClient(nameClientComapany);
		Assert.assertEquals(clientPage.getClientCompany(), nameClientComapany);
	}
	
	@Test
	public void addProject() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnProjectsOption();
		dashBoard.clickOnAllProjectsOption();
		String tilte = props.getProperty("projectTitle")+rand.nextInt(10000);
		allProjectsPage.addAProject(driver, tilte, props.getProperty("projectClientName"));	
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void applyLeave() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnLeaveOption();
		leavePage.applyLeave1(props.getProperty("reasonForLeave"));
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void assignLeave() {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnLeaveOption();
		leavePage.assignLeave(props.getProperty("teamMemberName"), props.getProperty("leaveTypeAssign"), props.getProperty("reasonAssign"));
	}
	
	@Test
	public void addExpense() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnFinanceOption();
		dashBoard.clickOnExpenses();
		String expenseTitle = props.getProperty("expenseTitle")+rand.nextInt(10000);
		expensePage.addNewExpense(props.getProperty("amount")+rand.nextInt(10000), expenseTitle);
		expensePage.searchExpense(expenseTitle);
		Assert.assertEquals(expensePage.getExpense(), expenseTitle);
	}
	
	@Test
	public void addTicket() throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnTickets();
		String ticketTitle = props.getProperty("ticketTitle")+rand.nextInt(10000); 
		ticketsPage.addTicket(ticketTitle, props.getProperty("ticketClient"), props.getProperty("ticketDescription"));
		ticketsPage.searchTicket(ticketTitle);
		Assert.assertEquals(ticketsPage.getTicket(), ticketTitle);
	}
	
	
	@Test(dataProvider = "myTickets")
	public void addTicket1(String ticketTitle, String ticketClient, String ticketDescription) throws InterruptedException {
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		dashBoard.clickOnTickets();
		ticketsPage.addTicket(ticketTitle, ticketClient, ticketDescription);
		ticketsPage.searchTicket(ticketTitle);
		Assert.assertEquals(ticketsPage.getTicket(), ticketTitle);
	}
	
	@DataProvider(name = "myTickets")
	public Object[][] testData(){
		Object[][] newData = new Object[2][3];
	//	newData[0][0] = props.getProperty("ticketTitle")+rand.nextInt(10000);
		newData[0][0] = "Ticket 1";
		newData[0][1] = "revathy";
		newData[0][2] = "Description 1";
		newData[1][0] = "Ticket 2";
		newData[1][1] = "revathy";
		newData[1][2] = "Description 2";
		return newData;
	}
}
