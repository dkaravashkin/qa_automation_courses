package com.course.lessons.ten;

import com.course.pageobjects.LinkedinLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

abstract class BaseTest {
    private WebDriver driver;
    protected LinkedinLoginPage linkedinLoginPage;

    @BeforeSuite
    public void setupTest() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("C:\\repos\\qa_automation_courses\\src\\main\\resources\\" + System.getProperty("ENV") + ".properties"));

        switch (props.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Browser " + props.getProperty("browser") + " is not supported");
        }
        linkedinLoginPage = new LinkedinLoginPage(driver);

    }

    @AfterTest
    public void teardown() {
        Allure.addAttachment("My screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        if (driver != null) {
            driver.quit();
        }
    }
}
