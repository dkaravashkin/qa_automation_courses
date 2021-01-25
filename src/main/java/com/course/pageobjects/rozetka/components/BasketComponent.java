package com.course.pageobjects.rozetka.components;

import com.course.pageobjects.rozetka.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketComponent extends BaseComponent {
    @FindBy(xpath = "//*[@class='modal__header']")
    private WebElement header;

    @FindBy(xpath = "//*[@class='button button_size_large button_color_green cart-receipt__submit']")
    private WebElement submit;

    private WebDriver driver;

    public BasketComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForBasket() {
        waitUtils.waitUntilElementVisible(header, 15);
    }

    public CheckoutPage clickSubmitButton() throws InterruptedException {
        waitUtils.waitUntilElementVisible(submit, 15);
        submit.click();
        return new CheckoutPage(driver);
    }
}
