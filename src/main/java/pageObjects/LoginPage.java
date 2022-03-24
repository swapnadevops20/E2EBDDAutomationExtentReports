package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;		


//Objects defined on the Top
//Methods defined After Objects defined


public class LoginPage {

	public WebDriver driver;
	
	By registerlink=By.cssSelector("a[id='reg_tab']");
	By emailtext=By.xpath("//input[@name='email']");
	By phonetext=By.xpath("//*[@id=\"register\"]/form/fieldset/div[3]/input");
	By registerwithpwdcheck=By.cssSelector("input[name='register_with_password']");
	By passwordtext=By.xpath("//*[@id=\"register\"]/form/fieldset/div[4]/input");
	By registerbtn=By.cssSelector("a[onclick*='signupLoginDsktpMngr.doRegistration']");
	//Account exists objects
	By accexistsemail=By.xpath("//*[@id=\"register\"]/form/fieldset/div[2]/div/span");
	By accexistsphone=By.xpath("//*[@id=\"register\"]/form/fieldset/div[3]/div/span");

	
	
	//otp  objects
	By otptext=By.xpath("//*[@id=\"verificationform\"]/div[2]/input");
	By verify=By.xpath("//a[@onclick='signupLoginDsktpMngr.doSignupLoginPhoneVerification(this)']");
	//sucessregister objects
	By successregister=By.xpath("//*[@id=\"loginModelBox\"]/div/div[2]/div[9]/div/div[1]/h2");
	By continue1=By.xpath("//*[@id=\"loginModelBox\"]/div/div[2]/div[9]/div/div[3]/a");

	
	//to bring life to driver please use constructor to avoid NullPointerException ie this.driver is  null
		//so create a constructor in LandingPage class which expects  argument
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
		}
		

		public WebElement getregister()      //instead of void v r using WebElement bec it is returning driver
		{
			
			return driver.findElement(registerlink);
		}
		
	
		
	public WebElement getEmailtxt()
	{
		return driver.findElement(emailtext);
		
	}
	
	public WebElement getPhonetxt()
	{
		return driver.findElement(phonetext);
		
	}
	
	public WebElement getPwdCheck()
	{
		return driver.findElement(registerwithpwdcheck);
		
	}
	
	public WebElement getPasswordtxt()
	{
		return driver.findElement(passwordtext);
		
	}
	
	public WebElement getregisterbtn()
	{
		return driver.findElement(registerbtn);
		
	}
	
	//assertions
	
	public WebElement getaccexistsemail()
	{
		return driver.findElement(accexistsemail);
		
	}
	
	public WebElement getaccexistsphone()
	{
		return driver.findElement(accexistsphone);
		
	}
	
	
	
}
