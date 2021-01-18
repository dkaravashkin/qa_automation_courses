package com.course.pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void getPage();

    public WebElement waitUntilElementVisible(WebElement element, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
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
