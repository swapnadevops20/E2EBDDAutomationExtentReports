//Adding Logs
//Generating HTML Reports
//Screenshots on Failure
//Maven Integrating with Jenkins

package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ValidationPage;
import resources.base;

public class stepDefination extends base{
	
	public static Logger log =LogManager.getLogger(base.class.getName());


	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		
		driver=initializeDriver();
		log.info("Driver is Initialized");
		
	}

	@Given("^Navigate to \"([^\"]*)\" WebSite$")
	public void navigate_to_something_website(String arg1) throws Throwable {
		driver.get(arg1);
		log.info("Navigated to Shopclues HomePage");
	}

	@Given("^Click on Signin Link in Home Page to land on Secure Signin Page$")
	public void click_on_signin_link_in_home_page_to_land_on_secure_signin_page() throws Throwable {
		
		LandingPage lp =new LandingPage(driver);
		Thread.sleep(3000);
		//popups handle
		if(lp.getnotificationSize()>0)
		{
		lp.getnotification().click();
		 log.info("Don't allow popup is Clicked");
		}

		Thread.sleep(5000);
		lp.getLogin().click();
		 log.info("Navigated to Signin Page");
		 Thread.sleep(5000);
		 
		 
	}

	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String emailid, String phno) throws Throwable {
		LoginPage lop=new LoginPage(driver);
		lop.getregister().click();
		 log.info("Navigated to Registration Form");
		 Thread.sleep(3000);

		lop.getEmailtxt().sendKeys(emailid);
		 log.info("Entered Email Id as Input Value");


		Thread.sleep(3000);
		lop.getPhonetxt().sendKeys(phno);
		 log.info("Entered Phone# as Input Value");

		Thread.sleep(3000);
		lop.getPwdCheck().click();
		 log.info("Register With Password Checked");

		Thread.sleep(3000);
		lop.getPasswordtxt().sendKeys("United@123");
		 log.info("Entered Password as Input Value");
		 lop.getregisterbtn().click();
		 log.info("Register Button is clicked");
		


    }

	
	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		 ValidationPage vp=new ValidationPage(driver);
		 log.info("Validating Tc's Using Assertions");
		 //validating TC'S using Assertions
		//Assert.assertequals
		String text1=vp.getaccexistsemail().getText();
		//System.out.println(text1);
		log.info("Email Text :" +text1);
		//this is true
		Assert.assertNotEquals(text1, "Account already exists with this email. Please login.");
		 log.info("Successfully validated EmailText message");

		String text2=vp.getaccexistsphone().getText();
		//this is false 
		Assert.assertEquals(text2, "Account already exists with this mobile number. Please login.");
		 log.info("Successfully validated PhoneText message");

		//System.out.println(text1);
		//System.out.println(text2)
			log.info("Email Text :" +text1);

			log.info("Phone Text :" +text2);

	
		//Assert.assertTrue
		////Assert.assertTrue(lop.getaccexistsemail().isDisplayed());
		
		//Assert.assertFalse
		////Assert.assertFalse(lop.getaccexistsemail().isDisplayed());
				
		//Parameterizing data to our TC's with the help of TestNG ----@DataProvider annotation
		

	}
	
	@And("^Close Browsers$")
    public void close_browsers() throws Throwable {
        driver.close();
        log.info("Driver is closed");
        }
}