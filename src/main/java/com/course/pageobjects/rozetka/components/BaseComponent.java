package com.course.pageobjects.rozetka.components;

import com.course.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected WaitUtils waitUtils;
    private WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }
}
