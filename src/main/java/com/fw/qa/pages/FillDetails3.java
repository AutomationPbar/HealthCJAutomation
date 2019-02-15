package com.fw.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fw.qa.baseclass.TestBase;

public class FillDetails3 extends TestBase {
	
	
	@FindBy(name="selectSelf")
	WebElement selfage;
	@FindBy(name="selectSpouse")
	WebElement spouseage;
	@FindBy(name="select8")
	WebElement sonage;
	
	@FindBy(name="select9")
	WebElement daughterage;
	
	@FindBy(xpath="//*[@id='idAbout']/section/div/div[1]/div[2]/form/div[1]/div/div[7]/div[2]/button/span")
	WebElement continuebtn;
	
	
public FillDetails3(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void filldetails(String sa,String spa,String soage,String dauage) throws Exception{
		
		Thread.sleep(5000);
		
		Select selfselect = new Select(selfage);
		selfselect.selectByValue(sa);
		
		Select spouseselect = new Select(spouseage);
		spouseselect.selectByValue(spa);
		
		Select sonselect = new Select(sonage);
		sonselect.selectByValue(soage);
		
		Select daughterselect = new Select(daughterage);
		daughterselect.selectByValue(dauage);
					
	}
	
	public FillDetails4 proceed(){
		
		continuebtn.click();
		return new FillDetails4();
		
	}

}
