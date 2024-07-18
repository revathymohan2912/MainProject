package BaseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {
	public WebDriver driver;
	
	public WebDriver browzerInitialization(String browzerName) throws Exception {
		if(browzerName.equalsIgnoreCase("chrome")){		//to achieve cross browzer testing
			driver = new ChromeDriver();
		}
		else if(browzerName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browzerName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Name Exception");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		//implicit wait
		return driver;
	}
	
	
	public String getSceenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testcaseName+".png";
		Files.copy(source, new File(destinationFile));
		return destinationFile;
	}

}
