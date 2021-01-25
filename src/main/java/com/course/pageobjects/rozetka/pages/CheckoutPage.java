package com.course.pageobjects.rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//*[@class='checkout-heading']")
    private WebElement checkoutHeading;

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void getPage() {
        driver.get("https://rozetka.com.ua/ua/checkout/");
    }

    public String getCheckoutHeading() {
        waitUtils.waitUntilElementVisible(checkoutHeading, 15);
        return checkoutHeading.getText();
    }
}
