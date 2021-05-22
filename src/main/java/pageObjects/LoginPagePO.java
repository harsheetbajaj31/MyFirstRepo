package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {
	
	public WebDriver driver;
	private By userid=By.xpath("//input[@id='user_email']");
	private By password=By.xpath("//input[@id='user_password']");
	private By login=By.xpath("//body/section[@id='hero']/div[1]/form[1]/div[3]/input[1]");
	public LoginPagePO(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getuserid()
	{
		return driver.findElement(userid);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}


	public WebElement getlogin() 
	{
		return driver.findElement(login);
	}

}
