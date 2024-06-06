package TestUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
 

	public static WebDriver browser;
 
	
	public void OpenBrowser(String BrowserName) {
		 
		 
		 if(BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			browser = new ChromeDriver();
			 
		 }else if(BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			browser = new FirefoxDriver();
			 
		 }else {
			 System.out.println("Please enter browser name from Chrome or FireFox");
		 }		
		browser.manage().window().maximize();		
	}
	
	public void NavigateToHomePage() {
	String projectpath = System.getProperty("user.dir");
		browser.get(projectpath+"\\src\\test\\resources\\Application\\QE-index.html");
	}
	public void CloseBrowser() {
		browser.close();
	}

}
