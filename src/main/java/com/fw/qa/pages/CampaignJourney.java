package com.fw.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.fw.qa.baseclass.TestBase;

public class CampaignJourney extends TestBase {
	
	@FindBy(id="name5")
	public
	WebElement mobileno;
	
	@FindBy(id="btnHealthStep1")
	public
	WebElement continuebtn1;
	
	////*[normalize-space(text()) and normalize-space(.)='Spouse'][1]/following::div[6]/input
	
	@FindBy(xpath="//*[@id='step_2']/div[2]/div[1]/div[1]/div[1]/div[1]/label")
	public
	WebElement male;
	
	@FindBy(id="txtName")
	public
	WebElement name;
	
	@FindBy(id="healthCityPincode")
	public
	WebElement city;
	
	@FindBy(xpath="//*[@id='ui-id-1']")
	public
	WebElement cityselect;
	
	@FindBy(id="btnHealthStep2")
	public
	WebElement continuebtn2;
	
	@FindBy(id="Spouse")
	public
	WebElement spouse;
	
	@FindBy(id="Son")
	public
	WebElement son;
	
	@FindBy(id="Daughter")
	public
	WebElement daughter;
	
	@FindBy(id="btnHealthStep3")
	public
	WebElement continuebtn3;
	
	@FindBy(xpath="//*[@id='step_4']/div[1]/div[2]/div[1]/div[1]/select")
	public
	WebElement selfage;
	
	@FindBy(xpath="//*[@id='step_4']/div[1]/div[2]/div[2]/div[1]/select")
	public
	WebElement spouseage;
	@FindBy(xpath="//*[@id='step_4']/div[1]/div[2]/div[4]/div[1]/select")
	public
	WebElement daughterage;
	
	@FindBy(xpath="//*[@id='step_4']/div[1]/div[2]/div[3]/div[1]/select")
	public
	WebElement sonage;
	
	@FindBy(id="btnHealthStep4")
	public
	WebElement continuebtn4;
	
public CampaignJourney(){
		
		PageFactory.initElements(driver, this);
	}


public void filldetailsage(String sa,String spa,String soage,String dauage) throws Exception{
	
	Thread.sleep(5000);
	
	Select selfselect = new Select(selfage);
	selfselect.selectByValue(sa);
	
	Select spouseselect = new Select(spouseage);
	spouseselect.selectByValue(spa);
	
	Select sonselect = new Select(sonage);
	sonselect.selectByValue(soage);
	
	Select daughterselect = new Select(daughterage);
	daughterselect.selectByValue(dauage);
	Thread.sleep(2000);

	try {

		driver.findElement(By.xpath("//*[@id='g-xx4onz']/span")).click();
		Thread.sleep(2000);
	} catch (Exception e) {

		
	}
	
	continuebtn4.click();
	
	Thread.sleep(9000);			
}
	
	
	public void selectdetails() throws Exception{
		
		Thread.sleep(4000);
	
		spouse.click();
		daughter.click();
		son.click();
		continuebtn3.click();
		Thread.sleep(4000);
			
	}
	
public void filldetails(String m,String nam,String cityname) throws Exception{
		
		Thread.sleep(4000);
	
		mobileno.sendKeys(m);
		continuebtn1.click();
		
		male.click();
		Thread.sleep(2000);
		
		name.sendKeys(nam);
		Thread.sleep(2000);
		
		city.sendKeys(cityname);
		Thread.sleep(2000);
		
		cityselect.click();
		Thread.sleep(2000);
		
		continuebtn2.click();
		
		Thread.sleep(5000);
			
	}
	
	
}
