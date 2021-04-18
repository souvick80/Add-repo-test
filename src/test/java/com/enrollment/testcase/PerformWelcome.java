/**
 * 
 */
package com.enrollment.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.enrollment.pages.Renewal.Welcome;
import com.enrollment.pages.common.Login;

/**
 * @author Souvick
 *
 * this class will perform to complete welcome page
 */


public class PerformWelcome {

	WebDriver driver=null;

	
	@Test
	public void performWelcome() {
		Welcome wc=PageFactory.initElements(driver, Welcome.class);
		wc.welcome();
	}
	
	

}
