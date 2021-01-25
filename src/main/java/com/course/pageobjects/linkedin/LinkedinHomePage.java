package com.course.pageobjects.linkedin;

import com.course.pageobjects.rozetka.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends BasePage {

    @FindBy(xpath = "//*[@class='nav__button-secondary']")
    private WebElement signIn;
    private WebDriver driver;

    public LinkedinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public void getPage() {
        driver.get("https://www.linkedin.com/");
    }

    public LinkedinSignInPage clickSignIn() {
        signIn.click();
        return new LinkedinSignInPage(driver);
    }
}
