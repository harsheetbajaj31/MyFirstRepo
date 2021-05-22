package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.homePagePO;
import resources.base;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefinition extends base {
	public WebDriver driver;
    @Given("^User lands on the URL \"([^\"]*)\"$")
    public void user_lands_on_the_url_something(String strArg1) throws Throwable {
    	driver=getDriverInvoked();
		driver.get("strArg1");
    }

    @When("^Title is checked$")
    public void title_is_checked() throws Throwable {
    	driver.manage().window().maximize();
    }


    @Then("^Title is correct or not$")
    public void title_is_correct_or_not() throws Throwable {
    	homePagePO hp=new homePagePO(driver);
    	Assert.assertEquals(hp.getTitle().getText(), "FEATURED COURS8ES");

}
}