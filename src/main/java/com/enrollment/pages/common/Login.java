/**
 * 
 */
package com.enrollment.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.CommonUtility;

/**
 * @author Souvick
 * this will contain all the elements and methods of renewal login page
 */
public class Login {

	public WebDriver driver;
	public Login(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//Object to generate Random String for last name
	CommonUtility cu= new CommonUtility();
	
	//User credential
	String lname=cu.randomString();//random string
	String dob="01012000";
	String phoneNo="1234567890";
	String email ="Test@test.com";
	String countryName="United States of America";

	//Renewal locators
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Renew today')]")WebElement renew_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Apply Now')]")WebElement applyNow_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'My TSA PreCheck')]")WebElement myTsa_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'I Accept')]")WebElement Privacy1_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'I ACCEPT')]")WebElement Privacy2_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'biographic data.')]")WebElement biographic_btn;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'KTN')]")WebElement ktn_btn;
	@FindBy(how=How.XPATH, using="//input[@id='enrollment_application_first_name_16241_16642']")WebElement renewalFirstName_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='enrollment_application_last_name_16241_16642']")WebElement renewalLastName_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='enrollment_application_date_of_birth_16241_16642']")WebElement renewalDob_txtBox;
	@FindBy(how=How.XPATH, using="//div[@id='get_started_country_of_birth']")WebElement renewalCountry_field;
	@FindBy(how=How.XPATH, using="//input[@id='enrollment_application_phone_no_16241_16642']")WebElement renewalPhone_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='enrollment_application_email_address_16241_16642']")WebElement renewalEmail_txtBox;
	@FindBy(how=How.XPATH, using="//div[@class='section-fields row']/div[1]/button/span[text()='Get Started']/parent::button")WebElement getStarted_btn;
	@FindBy(how=How.XPATH, using="//body/div[@id='menu-get_started_country_of_birth']/div[3]//child::li")WebElement country_drpDwn;
	@FindBy(how=How.XPATH, using="//li[@aria-label='%s']")WebElement countryName_drpdwn;
	
	//Pre Enrollment Locators
	@FindBy(how=How.XPATH, using="//input[@id='first_name_162311']")WebElement preEnrollmentFirstName_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='last_name_162311']")WebElement preEnrollmentLastName_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='date_of_birth_162311']")WebElement preEnrollmentDob_txtBox;
	@FindBy(how=How.XPATH, using="//div[@id='country_get_started_002']")WebElement preEnrollmentCountry_field;
	@FindBy(how=How.XPATH, using="//input[@id='phone_no_162311']")WebElement preEnrollmentPhone_txtBox;
	@FindBy(how=How.XPATH, using="//input[@id='email_address_162311']")WebElement preEnrollmentEmail_txtBox;

	String countryNamee_drpdwn = "//li[@aria-label='%s']";
	

		public void userlogin(String userType) throws InterruptedException {
			//Login login = new Login(driver);
	
		if(userType.equalsIgnoreCase("renewal")) 
		{
			
			renew_btn.click();
			Privacy1_btn.click();
			Privacy2_btn.click();
			biographic_btn.click();
			performRenewalLogin("Mock sc three test", lname, dob, phoneNo, email, countryName);
			Thread.sleep(10000);
			
		}
		else if(userType.equalsIgnoreCase("Pre enrollmet")) 
		{
			applyNow_btn.click();
			Privacy2_btn.click();
			Privacy2_btn.click();
			performPreEnrollmentLogin("Mock sc two test", lname, dob, phoneNo, email, countryName);
			
		}
		else
		{
			myTsa_btn.click();
			//performLogin("Mock sc two", lname, dob, phoneNo, email, countryName);
			
		}
	
	}
	
		
	public void performRenewalLogin(String fname, String lname, String dob, String phoneNo, String email, String countryName) throws InterruptedException
		{
			renewalFirstName_txtBox.sendKeys(fname);
			renewalLastName_txtBox.sendKeys(lname);
			renewalDob_txtBox.sendKeys(dob);
			renewalCountry_field.click();	
			driver.findElement(By.xpath(String.format(countryNamee_drpdwn, countryName))).click();
			renewalPhone_txtBox.sendKeys(phoneNo);
			renewalEmail_txtBox.sendKeys(email);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", getStarted_btn);    
			Thread.sleep(2000);
			try 
			{
				driver.findElement(By.xpath("//div[@class='section-fields row']/div[1]/button/span[text()='Get Started']/parent::button")).click();
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//div[@class='section-fields row']/div[2]/button/span[text()='Get Started']/parent::button")).click();
			}

			System.out.println("Renewal-First Name: "+fname);
			System.out.println("Renewal-Last Name: "+lname);
			System.out.println("Renewal-DOB: "+dob);	
		}
	
	
	public void performPreEnrollmentLogin(String fname, String lname, String dob, String phoneNo, String email, String countryName) throws InterruptedException
		{
		
			preEnrollmentFirstName_txtBox.sendKeys(fname);
			preEnrollmentLastName_txtBox.sendKeys(lname);
			preEnrollmentDob_txtBox.sendKeys(dob);
			preEnrollmentCountry_field.click();	
			driver.findElement(By.xpath(String.format(countryNamee_drpdwn, countryName))).click();
			preEnrollmentPhone_txtBox.sendKeys(phoneNo);
			preEnrollmentEmail_txtBox.sendKeys(email);
		
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", getStarted_btn);    
			Thread.sleep(2000);
			try 
			{
				driver.findElement(By.xpath("//div[@class='section-fields row']/div[1]/button/span[text()='Get Started']/parent::button")).click();
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//div[@class='section-fields row']/div[2]/button/span[text()='Get Started']/parent::button")).click();
			}
	
			System.out.println("Pre Enrollment-First Name: "+fname);
			System.out.println("Pre Enrollment-Last Name: "+lname);
			System.out.println("Pre Enrollment-DOB: "+dob);
		
		}
	
	
	
		
	
}
