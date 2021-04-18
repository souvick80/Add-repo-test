/**
 * 
 */
package Utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author souvick
 *
 * This class will contain all the common methods
 * 
 */


public class CommonUtility {
	
	//This will generate random  string
	
	public String randomString() {
		 
	    int length = 5;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    return generatedString.toLowerCase();
	
	}
	
	
	
	
	
	



}
