package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;

	public WebDriver getDriverInvoked() throws IOException {
	   /* Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\harsh\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\properties.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");*/

		String browsername = System.getProperty("browser");
		System.out.println(browsername);
		if (browsername.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\harsh\\Documents\\Harsheet Bajaj\\Professional\\Selenium + JAVA\\Drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return driver;
	}
	
	public String getScreenshotPath(String testmethodname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testmethodname+".png";
		FileUtils.copyFile(source,new File(destinationfile));
		
		return destinationfile;
	}
}
