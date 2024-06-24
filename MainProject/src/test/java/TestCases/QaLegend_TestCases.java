package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Base;
import PageClasses.QaLegendDashBoard;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCases extends Base{
	public WebDriver driver;
	Properties props;	//obj created for property class
	FileReader reader;
	QaLegendLoginPage loginPage;
	String path = "";
	QaLegendDashBoard dashBoard;
	QaLegendNotesPage notesPage;
	@BeforeMethod
	public void initialization() throws Exception {
		
		driver = browzerInitialization("chrome");
		loginPage = new QaLegendLoginPage(driver);
		dashBoard = new QaLegendDashBoard(driver);
		notesPage = new QaLegendNotesPage(driver);
		driver.manage().window().maximize();
		props = new Properties(); 				//initialize the obj
		path = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.properties";
		reader = new FileReader(path);
	//	reader = new FileReader("C:\\Users\\AKHIL\\git\\repositoryMainProj\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	//	reader = new FileReader("C:\\Users\\AKHIL\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		props.load(reader);
		driver.get(props.getProperty("url"));	//value readed from property file
		
	}
	@Test
	public void addNotes() {
		System.out.println("tc001");
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
	//	loginPage.loginToQaLegend("admin@admin.com", "12345678");
		System.out.println(path);
		dashBoard.clickOnNotesOption();
		notesPage.addNotes(props.getProperty("notesTitle"), props.getProperty("notesDescription"));
		
		}
	
}
