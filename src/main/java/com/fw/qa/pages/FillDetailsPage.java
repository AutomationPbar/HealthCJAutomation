package com.fw.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fw.qa.baseclass.TestBase;

public class FillDetailsPage extends TestBase {

	
	
	@FindBy(xpath="//*[@id='idAbout']/section/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div/a[1]/span/div")
	WebElement maleicon;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="mobilenumber")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id='idAbout']/section/div/div[1]/div[2]/form/div[1]/div/div[2]/div[1]/div/p[1]")
	WebElement nameerrortext;
	
	@FindBy(xpath="//*[@class='help is-danger' and @style='']")
	WebElement mobileerrortext;
	
	
	@FindBy(xpath="//*[@id='idAbout']/section/div/div[1]/div[2]/form/div[1]/div/div[3]/div/button/span")
	WebElement continuebtn;
	
	
	
	public FillDetailsPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void filldetails(String n,String mno) throws Exception{
		try{
		maleicon.click();
		}catch(Exception e){
			Thread.sleep(1000);
			maleicon.click();
		}
		name.sendKeys(n);
		mobile.sendKeys(mno);
	
	}
	
	public String nameerrormessage(){
		
		return nameerrortext.getText();
	}
	
public String mobileerrormessage(){
		
		
		return mobileerrortext.getText();
	}
	
	public FillDetails2 proceed(){
		try{
			Thread.sleep(2000);
		continuebtn.click();
		}catch(Exception e){
			
			continuebtn.click();
		}
		return new FillDetails2();
		
	}
	
}
