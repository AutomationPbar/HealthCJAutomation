package com.fw.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.fw.qa.baseclass.TestBase;

public class FillDetails2 extends TestBase {
	
	@FindBy(xpath="//*[@id='idAbout']/section/div/div[1]/div[2]/form/div[1]/div/div[5]/div[3]/button/span")
	WebElement continuebtn;
	
	////*[normalize-space(text()) and normalize-space(.)='Spouse'][1]/following::div[6]/input
	
	@FindBy(xpath="//*[normalize-space(text()) and normalize-space(.)='Self'][1]/following::div[6]/input")
	WebElement self;
	
	@FindBy(xpath="//*[normalize-space(text()) and normalize-space(.)='Spouse'][1]")
	WebElement spouse;
	
	@FindBy(xpath="//*[normalize-space(text()) and normalize-space(.)='Son'][1]")
	WebElement son;
	
	@FindBy(xpath="//*[normalize-space(text()) and normalize-space(.)='Daughter'][1]")
	WebElement daughter;
	
	
public FillDetails2(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectdetails() throws Exception{
		
		Thread.sleep(4000);
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click;",self);
		//self.click();
		
	
		spouse.click();
		daughter.click();
		son.click();
		
		
			
	}
	
	public FillDetails3 proceed(){
		continuebtn.click();
		return new FillDetails3();
		
	}
	
}
