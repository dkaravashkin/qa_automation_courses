package com.course.lessons;

import com.course.pageobjects.linkedin.LinkedinHomePage;
import com.course.pageobjects.rozetka.pages.RozetkaHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.Properties;

public abstract class BaseTest {
    private WebDriver driver;
    protected LinkedinHomePage linkedinHomePage;
    protected RozetkaHomePage rozetkaHomePage;
    protected Properties props;
    protected String userName;
    protected String password;

    @BeforeSuite
    public void setupTest() throws Exception {
        props = new Properties();
        props.load(new FileInputStream("C:\\repos\\qa_automation_courses\\src\\main\\resources\\dev.properties"));

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
        driver.manage().window().maximize();
        linkedinHomePage = new LinkedinHomePage(driver);
        rozetkaHomePage = new RozetkaHomePage(driver);
        userName = props.getProperty("userName");
        password = props.getProperty("password");
    }

    @AfterTest
    public void teardown() {
        Allure.addAttachment("My screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        if (driver != null) {
            driver.quit();
        }
    }
}
