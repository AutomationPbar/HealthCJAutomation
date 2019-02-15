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
import com.fw.qa.pages.FillDetails2;
import com.fw.qa.pages.FillDetails3;
import com.fw.qa.pages.FillDetails4;
import com.fw.qa.pages.FillDetailsPage;
import com.fw.qa.pages.HomeScreen;
import com.fw.qa.pages.QuotesDetailsPage;
import com.fw.qa.pages.QuotesPage;

public class TestCase1 extends TestBase{

	String nam = "test";
	String city = "Gurgaon";
	HomeScreen homescreen;
	FillDetailsPage detailspage1;
	FillDetails2 detailspage2;
	FillDetails3 detailspage3;
	FillDetails4 detailspage4;
	QuotesPage quotespage;
	QuotesDetailsPage quotesdetails;
	

	String m = "9777777777";
	String c = "Gurgaon";
	String selfage = "35";
	String spousea = "32";
	String sonage = "3";
	String daughterage = "6";
	String errormsg;
	int index;
	

	public TestCase1(){
		
		super();
	}
	
@BeforeTest
	
	public void reportsetup(){
		
		extentreport();
		
	}

@BeforeMethod

public void setup(){
	
	initialization();
	homescreen = new HomeScreen();
	detailspage1 = HomeScreen.healthpage();
	
}

@Test 
	public void blanknametest() throws Exception{
	
	extenttest = extent.startTest("Blank name test");
	System.out.println("Blank name test");
	nam = "";
	detailspage1.filldetails(nam,m);
	detailspage1.proceed();
	errormsg= detailspage1.nameerrormessage();
	Assert.assertEquals(errormsg, "Required","String does not match");	
	}

@Test 
public void spacenametest() throws Exception{

	extenttest = extent.startTest("Extra space name test");
	System.out.println("Extra Space name test");
	nam = "test  abcd";
	detailspage1.filldetails(nam,m);
	detailspage1.proceed();
	errormsg= detailspage1.nameerrormessage();
	Assert.assertEquals(errormsg, "","String does not match");	
}

@Test 
public void blankmobiletest() throws Exception{

	extenttest = extent.startTest("Blank mobile number test");
	System.out.println("Blank mobile numbertest");
	nam = "test";
	m = "";
		index = 0;
		detailspage1.filldetails(nam,m);
		detailspage1.proceed();
		errormsg= detailspage1.mobileerrormessage();
		Assert.assertEquals(errormsg, "Required","String does not match");	
}

@Test 
public void invalidmobiletest() throws Exception{

	extenttest = extent.startTest("Invalid mobile number test");
	System.out.println("Invalid mobile number test");
	nam = "test abcd";
	m= "1234567890";
	index = 1;
	detailspage1.filldetails(nam,m);
	detailspage1.proceed();
	errormsg= detailspage1.mobileerrormessage();
	Assert.assertEquals(errormsg, "Number should start with 6, 7, 8 or 9.","String does not match");	
}

@Test 
public void invalidmobiletest2() throws Exception{

	extenttest = extent.startTest("Invalid mobile number test 2");
	System.out.println("Invalid mobile number test 2");
	nam = "test abcd";
	m= "67890";
	index = 0;
	detailspage1.filldetails(nam,m);
	detailspage1.proceed();
	errormsg= detailspage1.mobileerrormessage();
	Assert.assertEquals(errormsg, "Please enter valid contact number","String does not match");	
}

@Test 
public void quotespage() throws Exception{

	extenttest = extent.startTest("Quotes page test");
	System.out.println("Quotes page test");
	nam = "test abcd";
	m= "9777777777";
	detailspage1.filldetails(nam,m);
	detailspage2 = detailspage1.proceed();
	detailspage2.selectdetails();
	detailspage3 = detailspage2.proceed();

	detailspage3.filldetails(selfage, spousea, sonage, daughterage);
	System.out.println("clicking continue after selecting age");
	detailspage4 = detailspage3.proceed();

	detailspage4.filldetails(city);

	quotespage = detailspage4.proceed();

	Assert.assertEquals(quotespage.displayed(),"Base Plans","element not displayed");
}

@AfterMethod

public void reportteardown(ITestResult result) throws IOException{
	
	extentteardown(result);
	driver.close();
}

@AfterTest
public void teardown() throws IOException{
	
	endreport();
	driver.quit();
}

}
