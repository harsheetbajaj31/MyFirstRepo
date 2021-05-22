package CucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class testRunner {

	//@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src/test/java/login.feature",
			glue="stepDefinations")	
	public class TestRunner extends AbstractTestNGCucumberTests{
		
	}
}
