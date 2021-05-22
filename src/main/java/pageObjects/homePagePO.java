package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePagePO {
	
	public WebDriver driver;
	private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By login=By.xpath("//span[contains(text(),'Login')]");
	
	public homePagePO(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
}
