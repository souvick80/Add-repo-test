/**
 * 
 */
package com.enrollment.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.enrollment.pages.common.Login;

import Utility.BrowserFactory;
import Utility.CommonUtility;


/**
 * @author Souvick
 * 
 * This will verify Renewal Login with valid user.
 */
public class VerifyLogin extends Base {
	
	public VerifyLogin(WebDriver driver) {
		super(driver);
	}

	//WebDriver driver=null;
	
//	public VerifyLogin(WebDriver driver) {
//		driver=this.driver;
//	}

	@Test
	public void checkValidUser() throws InterruptedException, IOException {
		
		
//		String browser="chrome"; 			//chrome, firefox
//		String url="https://ss2-enrollment-app-dev.inadev.net/";
		String userType="renewal"; 			//renewal, Pre enrollmet
//		
		//this will launch the browser and specific URL
	//	driver=BrowserFactory.startBrowser(browser, url);
	
		//initializing the RenewalLogin object
		Login login = new Login(driver);
		
		//Passing first Name, Last name, DOB, Country, Phone, Email as argument to complete the execution
		login.userlogin(userType);
	
		
		
		
		
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//		
//	}
//	

}
