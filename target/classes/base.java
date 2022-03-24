package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver initializeDriver() throws IOException
	{
		//create datadriven properties file
		prop=new Properties();
		//Given the path where exactly the datadriven file located
		FileInputStream fis=new FileInputStream("\\Users\\User\\eclipse-workspace2022\\E2EAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Users\\User\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("ChromeDriver is opened");

		}
		else if(browserName.equals("firefox"))
		{

			System.setProperty("webdriver.gecko.driver","D:\\Users\\User\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
			log.info("FirefoxDriver is opened");

		
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Users\\User\\geckodriver-v0.30.0-win64\\IEDriverServer.exe");  
	          
		     // Instantiate a IEDriver class.     
		driver=new InternetExplorerDriver();  
		log.info("IEDriver is opened");

		}
		
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
		return driver;
		
		
	

	}

}
