package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationPage {
	
	public WebDriver driver;

	//Account exists objects
		By accexistsemail=By.xpath("//*[@id=\"register\"]/form/fieldset/div[2]/div/span");
		By accexistsphone=By.xpath("//*[@id=\"register\"]/form/fieldset/div[3]/div/span");
		
		public ValidationPage(WebDriver driver)
		{
			this.driver=driver;
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
