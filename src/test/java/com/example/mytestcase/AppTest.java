package com.example.mytestcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");               // run without GUI
        options.addArguments("--no-sandbox");             // required in Docker/WSL
        options.addArguments("--disable-dev-shm-usage");  // prevent crashes on small /dev/shm
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);  //set it right
        
        
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
