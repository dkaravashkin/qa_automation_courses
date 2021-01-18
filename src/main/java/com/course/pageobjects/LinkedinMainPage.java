package com.course.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinMainPage extends BasePage {
    @FindBy(xpath = "//*[@data-control-name='nav.messaging']")
    private WebElement messaging;
    private WebDriver driver;

    public LinkedinMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isMessagingPresent() {
        return isElementPresent(messaging, 15);
    }

    public void assertMessagingIsPresent() {
        assertElementIsVisible(messaging, 0, "Messaging was not found");
    }

    @Override
    public void getPage() {
        driver.get("https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin");
    }
}
