package pageObjects;
import java.util.List;

import org.openqa.selenium.*;		


//Objects defined on the Top
//Methods defined After Objects defined


public class LandingPage {

	public WebDriver driver;
	
	By popup=By.cssSelector("button[class*='moe-btn-close']");
	By Signin=By.xpath("//*[@id='sign-in']/a");
	
	
	
	//to bring life to driver please use constructor to avoid NullPointerException ie this.driver is  null
		//so create a constructor in LandingPage class which expects  argument
		
		public LandingPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public int getnotificationSize()      //instead of void v r using WebElement bec it is returning driver
		{
			
			return driver.findElements(popup).size();
		}
		

		public WebElement getnotification()      //instead of void v r using WebElement bec it is returning driver
		{
			
			return driver.findElement(popup);
		}
		
	
		
	public WebElement getLogin()
	{
		return driver.findElement(Signin);
		
	}
	
}
