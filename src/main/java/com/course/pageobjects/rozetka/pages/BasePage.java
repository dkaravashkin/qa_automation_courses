package com.course.pageobjects.rozetka.pages;

import com.course.utils.WaitUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WaitUtils waitUtils;
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    protected abstract void getPage();
}
