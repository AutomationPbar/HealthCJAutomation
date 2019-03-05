package com.fw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fw.qa.baseclass.TestBase;

public class HomeScreen extends TestBase {
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/ul/li[2]/a")
	static
	WebElement health;
	
	public HomeScreen(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateHomePageTitle(){
		
		return driver.getTitle();
		
	}
	
	public static FillDetailsPage healthpage(){
		
		health.click();
		return new FillDetailsPage();
	}

}
