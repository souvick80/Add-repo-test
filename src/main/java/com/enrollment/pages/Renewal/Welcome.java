package com.enrollment.pages.Renewal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Welcome {
	
	
	@FindBy(how=How.XPATH, using="//input[@id='name_change_radio_question_renewal-0']")WebElement nameChange_radioBtn;
	@FindBy(how=How.XPATH, using="//button[@aria-label='Click on Yes, Renew Now']")WebElement renewNow_btn;
	@FindBy(how=How.XPATH, using="//span[text()='Continue']")WebElement continue_btn;
	
		public void welcome() {
			nameChange_radioBtn.click();
			renewNow_btn.click();
			continue_btn.click();
		}
}
