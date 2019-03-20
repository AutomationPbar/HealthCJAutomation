package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fw.qa.baseclass.TestBase;
import com.fw.qa.pages.CampaignJourney;
import com.fw.qa.pages.FillDetails2;
import com.fw.qa.pages.FillDetails3;
import com.fw.qa.pages.FillDetails4;
import com.fw.qa.pages.FillDetailsPage;
import com.fw.qa.pages.HomeScreen;
import com.fw.qa.pages.QuotesDetailsPage;
import com.fw.qa.pages.QuotesPage;

public class TestCaseCampaignJourney extends TestBase{

	String nam = "test";
	String city = "Gurgaon";
	HomeScreen homescreen;
	CampaignJourney cj;
	

	String m = "9777777777";
	String c = "Gurgaon";
	String selfage = "35";
	String spousea = "32";
	String sonage = "3";
	String daughterage = "6";
	String errormsg;
	int index;
	

	public TestCaseCampaignJourney(){
		
		super();
	}
	
@BeforeTest
	
	public void reportsetup(){
		
		extentreport();
		
	}

@BeforeMethod

public void setup(){
	
	initialization();
	//homescreen = new HomeScreen();
	try {
		Thread.sleep(5000);
		
		driver.get("https://www.policybazaar.com/health-insurance/??utm_source=test1&utm_term=test2&utm_medium=test3&utm_campaign=test4&utm_content=test5");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	cj = new CampaignJourney();
}


@Test  (priority = 1)
public void quotespage(){
	try{
	extenttest = extent.startTest("Quotes page test");
	System.out.println("Quotes page test");
	
	System.out.println("title " + driver.getTitle());
	nam = "testabcd";
	m= "9777777777";
	Thread.sleep(3000);
	cj.filldetails(m,nam,city);
	
	cj.selectdetails();
	
	cj.filldetailsage(selfage, spousea, sonage, daughterage);
	System.out.println("clicking continue after selecting age");
	
	}catch (Exception e){
		e.printStackTrace();
	}
}

@AfterMethod

public void reportteardown(ITestResult result) throws IOException{
	
	extentteardown(result);
	//driver.close();
}

@AfterTest
public void teardown() throws IOException{
	
	endreport();
	//driver.quit();
}

}
