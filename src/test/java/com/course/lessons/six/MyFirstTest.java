package com.course.lessons.six;

import org.testng.Assert;
import org.testng.annotations.*;

public class MyFirstTest {

    @BeforeClass
    public void setupClass(){
        System.out.println("Setup class");
    }

    @BeforeTest
    public void setupTest(){
        System.out.println("Setup test");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("Setup method");
    }

    @BeforeSuite
    public void setupSuite(){
        System.out.println("Setup suite");
    }

    @Test(description = "This is first basic test", priority = 1, enabled = true)
    public void basicTest() {
        System.out.println("First test executed");
        Assert.assertEquals(2, 2);
    }

    @Test(description = "This is second basic test", priority = 0, enabled = true)
    public void basicTest2() {
        System.out.println("Second test executed");
        Assert.assertEquals(2, 5);
    }

    @AfterClass
    public void teardownClass(){
        System.out.println("Teardown class");
    }

    @AfterTest
    public void teardownTest(){
        System.out.println("Teardown test");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("Teardown method");
    }

    @AfterSuite
    public void teardownSuite(){
        System.out.println("Teardown suite");
    }
}
