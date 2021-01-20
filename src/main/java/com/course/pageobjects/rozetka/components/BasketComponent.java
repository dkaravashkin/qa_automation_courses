package com.course.pageobjects.rozetka.components;

import com.course.pageobjects.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketComponent extends BaseComponent {
    private WebDriver driver;

    public BasketComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
