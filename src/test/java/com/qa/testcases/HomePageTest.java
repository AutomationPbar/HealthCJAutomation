package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fw.qa.baseclass.TestBase;
import com.fw.qa.pages.FillDetailsPage;
import com.fw.qa.pages.HomeScreen;

public class HomePageTest extends TestBase {
	
	HomeScreen homepage;
	FillDetailsPage detailspage;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	
	public void setup(){
		
		initialization();
		homepage = new HomeScreen();
		
		
	}
	
	
	@Test
	public void clickjourney(){
		
		detailspage = HomeScreen.healthpage();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
