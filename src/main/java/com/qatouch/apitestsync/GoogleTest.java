package com.qatouch.apitestsync;
import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleTest {
	public static WebDriver driver;
	public String projectKey="********projectKey***********";
	public String testrunid = "*********TESTRUNID**********";
	public String resultKey;
	public String newstatus = "passed";
	public String failstatus = "failed";
	public String newcomments="Updated from QA Touch API";
	
	@BeforeSuite
	public void openBrowser()
	{
 
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","//Users//dckap//Activities//java-workspace//lib");
		driver.get("https://www.google.com/");
	    System.out.println("We are currently on the following URL:" +driver.getCurrentUrl());
	}
	
	@Test
    public void isSearchExist() {
	resultKey = "DbK9WZ";
       boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
	}
	
    @Test    
	public void titleTest() {
    	resultKey = "vwkZPw";
    		driver.get("https://www.google.com/");
            String title = driver.getTitle();
            System.out.println("page title:" + title);
            AssertJUnit.assertEquals(title, "Googlet");
        }
	     
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
	
	// Sync Test Results to QA Touch
   @AfterMethod
   public void addResultForTestCase(ITestResult result) {
       
	   AddResultNew obj = new AddResultNew(); 
	 
	   System.out.println(result);
	   if (result.isSuccess()) {
		   System.out.println("Success");
		   obj.addTestRunStatus(null,testrunid,projectKey,resultKey,newstatus,newcomments);
	       }
   		else  {
   		 obj.addTestRunStatus(null,testrunid,projectKey,resultKey,failstatus,newcomments);
	   
      }
    }  
}
	