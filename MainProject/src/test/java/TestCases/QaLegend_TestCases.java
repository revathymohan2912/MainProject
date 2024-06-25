package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import BaseClass.Base;
import PageClasses.QaLegendDashBoard;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCases extends Base{
	public WebDriver driver;
	Properties props;	//obj created for property class
	FileReader reader;
	String path = "";
	QaLegendLoginPage loginPage;
	QaLegendDashBoard dashBoard;
	QaLegendNotesPage notesPage;
	
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
		
		
	//	reader = new FileReader("C:\\Users\\AKHIL\\git\\repositoryMainProj\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	//	reader = new FileReader("C:\\Users\\AKHIL\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		
		
		
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
