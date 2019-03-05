package com.fw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fw.qa.baseclass.TestBase;

public class FillDetails4 extends TestBase {
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(xpath="//*[@id='cityinput']/div[1]/div/div/div/div/ul/li")
	WebElement selectcity;
	
	@FindBy(xpath="//*[@id='cityinput']/div[2]/div/div/label/div/a[3]/div")
	WebElement income;
	
	
	@FindBy(xpath="//*[@id='cityinput']/div[3]/div/button/div/span")
	WebElement viewplans;
	
	
public FillDetails4(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void filldetails(String c){
		
		city.sendKeys(c);
		
		try {
			Thread.sleep(1500);
			
			selectcity.click();
			
			income.click();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	public QuotesPage proceed(){
		viewplans.click();
		return new QuotesPage();
		
	}

}
