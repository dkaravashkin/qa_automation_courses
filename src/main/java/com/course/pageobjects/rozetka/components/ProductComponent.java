package com.course.pageobjects.rozetka.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComponent extends BaseComponent {

    @FindBy(xpath = "//*[@class='buy-button button button_with_icon button_color_green button_size_large' and @aria-label='Купити']")
    private WebElement buyBtn;
    private WebDriver driver;

    public ProductComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void buyProduct() {
        waitUtils.waitUntilElementVisible(buyBtn, 10);
        buyBtn.click();
    }
}
