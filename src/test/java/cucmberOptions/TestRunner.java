package cucmberOptions;

//This is Junit Library not TestNG library
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/java/features/Login.feature", 
                  glue="stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests{

}
