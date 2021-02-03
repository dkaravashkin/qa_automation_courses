package com.course.lessons;

import com.course.lessons.nine.MvnTests;
import com.course.pageobjects.linkedin.LinkedinHomePage;
import com.course.pageobjects.rozetka.pages.RozetkaHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public abstract class BaseTest {
    private WebDriver driver;
    protected LinkedinHomePage linkedinHomePage;
    protected RozetkaHomePage rozetkaHomePage;
    protected Properties props;
    protected String userName;
    protected String password;
    private static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupSuite() throws Exception {
        logger.info("Starting setup tests........");
        logger.info("Setup properties");
        props = new Properties();
        File propsFile = new File("src/main/resources/properties/dev.properties");
        props.load(new FileInputStream(propsFile));

        logger.info("Setup driver");
        switch (props.getProperty("browser")) {
            case "chrome":
                /* Remote execution
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc); */

                //Local execution
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
        logger.info("Initialize page");
        linkedinHomePage = new LinkedinHomePage(driver);
        rozetkaHomePage = new RozetkaHomePage(driver);
        userName = props.getProperty("userName");
        password = props.getProperty("password");
    }

    @AfterTest
    public void teardown() {
        logger.info("Shutdown tests........");
        Allure.addAttachment("My screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        if (driver != null) {
            driver.quit();
        }
    }
}
