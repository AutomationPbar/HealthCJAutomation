package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fw.qa.baseclass.TestBase;
import com.fw.qa.pages.FillDetails2;
import com.fw.qa.pages.FillDetails3;
import com.fw.qa.pages.FillDetails4;
import com.fw.qa.pages.FillDetailsPage;
import com.fw.qa.pages.HomeScreen;
import com.fw.qa.pages.QuotesDetailsPage;
import com.fw.qa.pages.QuotesPage;

public class FillDetailsPage1Test extends TestBase {
	
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
	
	public FillDetailsPage1Test(){
		
		super();
	}
	
	@BeforeMethod
	
	public void setup(){
		
		initialization();
		homescreen = new HomeScreen();
		detailspage1 = homescreen.healthpage();
		
	}
	
	
	@Test
	public void getquotestest(){
		
		System.out.println(driver.getTitle());
		try {
			detailspage1.filldetails(nam,m);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		detailspage2 = detailspage1.proceed();
	
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		try {
			detailspage2.selectdetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		detailspage3 = detailspage2.proceed();
		
		try {
			detailspage3.filldetails(selfage, spousea, sonage, daughterage);

			System.out.println("clicking continue after selecting age");
			detailspage4 = detailspage3.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		detailspage4.filldetails(city);
		
		quotespage = detailspage4.proceed();	
		
		quotesdetails = quotespage.proceed();
	}

}

