package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Base;
import PageClasses.QaLegendLoginPage;

public class QaLegend_TestCases extends Base{
	public WebDriver driver;
	Properties props;	//obj created for property class
	FileReader reader;
	QaLegendLoginPage loginPage;
	
	@BeforeMethod
	public void initialization() throws Exception {
		
		driver = browzerInitialization("chrome");
		loginPage = new QaLegendLoginPage(driver);
		driver.manage().window().maximize();
		props = new Properties(); //initialize the obj
		reader = new FileReader("C:\\Users\\AKHIL\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		props.load(reader);
		driver.get(props.getProperty("url"));	//value readed from property file
		
	}
	@Test
	public void addNotes() {
		System.out.println("tc001");
		loginPage.loginToQaLegend(props.getProperty("username"), props.getProperty("password"));
		//loginPage.loginToQaLegend("admin@admin.com", "12345678");
		
	}
}
