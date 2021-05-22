package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPagePO;
import pageObjects.homePagePO;
import resources.base;

public class homePage extends base {
	
	@Test
	public void testValiditingTitle() throws IOException
	{
		driver=getDriverInvoked();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		homePagePO hp=new homePagePO(driver);
		String text=hp.getTitle().getText();
		Assert.assertEquals(text, "FEATURED COURS8ES");
	}
	
	@Test
	public void testlogin() throws IOException
	{
		driver=getDriverInvoked();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		homePagePO hp=new homePagePO(driver);
		hp.getlogin().click();
		LoginPagePO lp=new LoginPagePO(driver);
		lp.getuserid().sendKeys("firstuser");
		lp.getpassword().sendKeys("firstpassword");
		lp.getlogin().click();
	}
	
	
	@AfterTest
	public void windowCloser()
	{
		driver.close();
	}
	

}
