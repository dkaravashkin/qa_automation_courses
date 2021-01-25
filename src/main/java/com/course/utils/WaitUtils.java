package com.course.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementVisible(WebElement element, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementClickable(WebElement element, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(WebElement element, int timeOutInSec) {
        try {
            waitUntilElementVisible(element, timeOutInSec);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void assertElementIsVisible(WebElement element, int timeOutInSec, String message) {
        try {
            waitUntilElementVisible(element, timeOutInSec);
        } catch (TimeoutException e) {
            throw new AssertionError(message);
        }
    }
}
