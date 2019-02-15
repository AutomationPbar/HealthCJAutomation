//sample class for framework page factory
package com.fw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fw.qa.baseclass.TestBase;

public class QuotesDetailsPage extends TestBase {

	@FindBy(xpath="//*[@id='summary']/div[8]/div/div[3]/div[1]/div/div[2]/div/div[1]/div[12]/div/button/span")
	WebElement quote;
	
	public QuotesDetailsPage(){
		
		PageFactory.initElements(driver, this);
	}
	
}

