//sample class for framework page factory
package com.fw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.fw.qa.baseclass.TestBase;

public class QuotesPage extends TestBase {

	@FindBy(xpath="//*[@id='divquote']/div[7]/div/div/div[3]/div/div/div[23]/div[1]/span/div[1]/div[5]/button")
	WebElement quote;
	
	@FindBy(xpath="//*[@id='divquote']/div[8]/div/div/div[1]/div/div/div/button[1]")
	WebElement baseplan;
	
	public QuotesPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String displayed(){
		
		try{
			Thread.sleep(2000);
		return baseplan.getText();
		}
		catch(Exception e){
			return baseplan.getText();
		}
	}
	
	public QuotesDetailsPage proceed(){
		quote.click();
		return new QuotesDetailsPage();
		
	}
	
}

