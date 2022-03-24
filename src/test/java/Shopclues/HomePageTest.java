package Shopclues;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ValidationPage;
import resources.base;

public class HomePageTest extends base{

	public WebDriver driver;              //when v work in parallel use this driver outside in each test bec this is local copy
	public static Logger log =LogManager.getLogger(base.class.getName());
	//prerqisite before validating scenarios
	@BeforeTest          
	public void initialize() throws IOException
	
	{
		driver=initializeDriver();     //initializeDriver method returning driver in base class
		 log.info("Driver is initialized");
		
	}
	
	//validating scenarios
	@Test(dataProvider="getData")
	public void baseNavigationPage(String email,String phone,String pwd) throws IOException, InterruptedException
	{	
		//v should not hardcode URL
				driver.get(prop.getProperty("url"));
				 log.info("Navigated to Shoclues Home page");

			
		//1.Creating Object for the class LandingPage and invoke the methods instead of inheritance   2.2nd method is extends ie inheritance
		LandingPage lp =new LandingPage(driver);
		LoginPage lop=new LoginPage(driver);
		Thread.sleep(3000);
		lp.getnotification().click();
		 log.info("Allow Notification");

		Thread.sleep(3000);
		lp.getLogin().click();
		 log.info("Navigated to Signin Page");

		Thread.sleep(5000);
		//
		lop.getregister().click();
		 log.info("Navigated to Registration Form");

		Thread.sleep(3000);
		lop.getEmailtxt().sendKeys(email);
		 log.info("Entered Email Id as Input Value");

	
		Thread.sleep(3000);
		lop.getPhonetxt().sendKeys(phone);
		 log.info("Entered Phone# as Input Value");

		Thread.sleep(3000);
		lop.getPwdCheck().click();
		 log.info("Register With Password Checked");

		Thread.sleep(3000);
		lop.getPasswordtxt().sendKeys(pwd);
		 log.info("Entered Password as Input Value");

		Thread.sleep(3000);
		lop.getregisterbtn().click();
		 log.info("Register Button is clicked");
		 log.info("Validating Tc's Using Assertions");

		 ValidationPage vp=new ValidationPage(driver);
		//validating TC'S using Assertions
		//Assert.assertequals
		String text1=vp.getaccexistsemail().getText();
		//System.out.println(text1);
		log.info(text1);
		//this is true
		Assert.assertNotEquals(text1, "Account already exists with this email. Please login.");
		 log.info("Successfully validated EmailText message");

		String text2=vp.getaccexistsphone().getText();
		//this is false 
		Assert.assertEquals(text2, "Account already exists with this mobile number. Please login.");
		 log.info("Successfully validated PhoneText message");

		//System.out.println(text1);
		//System.out.println(text2)
			log.info(text1);

			log.info(text2);

	
		//Assert.assertTrue
		////Assert.assertTrue(lop.getaccexistsemail().isDisplayed());
		
		//Assert.assertFalse
		////Assert.assertFalse(lop.getaccexistsemail().isDisplayed());
				
		//Parameterizing data to our TC's with the help of TestNG ----@DataProvider annotation
		
	}
	
	//close after validating scenarios
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("All Browsers are closed");
		log.info("Driver is closed");

	}
	
	@DataProvider
		public Object[][] getData()
		{
			//rows stands for h many different data sets ie combinations to run
			//columns stands for how many values
		log.info("Enter Test Sets Data");

			Object[][] data=new Object[2][3];
			data[0][0]="swapnareddi.mca@gmail.com";
			data[0][1]="9704584916";
			data[0][2]="United@123";
			
			
			data[1][0]="swapnareddi.mca@gmail.com";
			data[1][1]="97045";
			data[1][2]="United@123";
			
			return data;
			
			
		}
				
	}
