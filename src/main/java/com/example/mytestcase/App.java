package com.example.mytestcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
	WebDriver driver;
	
	@Test
    public void verifyTitle() 
    {
    	    driver.manage().window().maximize();
	        driver.get("https://www.google.com");
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Google";
	        
	        System.out.println("Expected Title is " + expectedTitle);
	        System.out.println("Actual Title is " + actualTitle);
	        
	        if(actualTitle.equals(expectedTitle))
	        {
	        	System.out.println("Test Case Passed");
	        }	        	
	        else
	        {
	        	System.out.println("Test Case Failed");
	        }
	        
	        Assert.assertEquals(actualTitle, expectedTitle);
	        
    }
    
    @BeforeTest
    public void setUp()
    {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    
    @AfterTest
    public void tearDown()
    {
    	driver.quit();
    }
}
