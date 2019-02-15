package com.qa.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fw.qa.baseclass.TestBase;

public class SampleTestCase extends TestBase{
	
	@BeforeTest
	public void setup(){
		
		initialization();
		extentreport();
		
	}

	@Test
	public void launch(){
		
		extenttest = extent.startTest("test");
		System.out.println("testing testing");
		Assert.assertEquals(true, true);
		
	}
	@Test
	public void title(){
		
		extenttest = extent.startTest("titletest");
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Google@123","Title dows not match");
		
	}
	@AfterMethod
	
	public void reportteardown(ITestResult result) throws IOException{
		
		extentteardown(result);
	}
	
	@AfterTest
	public void teardown() throws IOException{
		
		endreport();
		driver.close();
		driver.quit();
	}
}
