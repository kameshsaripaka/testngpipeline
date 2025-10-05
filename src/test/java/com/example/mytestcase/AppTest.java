package com.example.mytestcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AppTest {

	private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Automatically download correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title should contain Google");
        System.out.println("Page title: " + driver.getTitle());
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
