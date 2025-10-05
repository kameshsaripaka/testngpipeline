package com.example.mytestcase;


//import org.junit.jupiter.api.Test;


import org.testng.Assert;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;


public class AppTest {


	@BeforeClass
    public void setup() {
        System.out.println("=== Setup executed before tests ===");
    }

    @Test
    public void testHello() {
        System.out.println("=== Running testHello ===");
        Assert.assertEquals("Hello".toUpperCase(), "HELLO");
    }

    @Test
    public void testFailCase() {
        System.out.println("=== Running testFailCase ===");
        Assert.assertTrue(5 < 10, "Intentional failure for demo");
    }
}
