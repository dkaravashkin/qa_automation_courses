package com.course.lessons.eight;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestWaits {

    private WebDriver driver;

    @FindBy(xpath = "//*[@href='/dynamic_controls']")
    WebElement dynamicControlsBtn;

    @FindBy(xpath = "//*[@type='button' and text()='Remove']")
    WebElement removeBtn;

    @FindBy(xpath = "//*[@type='button' and text()='Add']")
    WebElement addBtn;

    @FindBy(xpath = "//*[@id='checkbox']")
    WebElement checkbox;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testWaits() {
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);

        driver.get("https://the-internet.herokuapp.com/");
        dynamicControlsBtn.click();
        removeBtn.click();
        waitUntilElementVisible(addBtn).click();
        waitUntilElementVisible(checkbox).click();
    }

    //Explicit
    public WebElement waitUntilElementVisible(WebElement element, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementClickable(WebElement element, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Fluent
    public WebElement waitUntilElementVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
