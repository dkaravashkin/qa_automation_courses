package com.course.lessons.six;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyFirstSeleniumTest {

    @Test
    public void seleniumTest() {
        System.setProperty("webdriver.chrome.driver", "path to driver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://gmail.com");
    }
}
