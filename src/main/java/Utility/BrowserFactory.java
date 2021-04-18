/**
 * 
 */
package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * @author OPTLPTP298
 *
 *This will initiate the browser
 */
public class BrowserFactory {
	
	

	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url) throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		
		switch(browserName) {
		case "firefox": 
			System.setProperty("webdriver.gecko.driver", "D:\\FirefoxDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver-89\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Please type firefox or chrome as a browserName parameter");
			
			}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(10000);
		return driver;
		
		
	}
	
	
}
