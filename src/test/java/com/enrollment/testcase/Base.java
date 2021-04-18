/**
 * 
 */
package com.enrollment.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.enrollment.pages.Renewal.Welcome;

import Utility.BrowserFactory;

/**
 * @author OPTLPTP298
 *
 */
public class Base {
	
	public static WebDriver driver;
	
	

	public Base(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@BeforeTest
	public static WebDriver startBrowser(String browserName) throws IOException  {
		
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
		return driver;
		
	}
	
	@Test
	public void openUrl() {
		driver.get("https://ss2-enrollment-app-dev.inadev.net/");
	}
	

	
}
