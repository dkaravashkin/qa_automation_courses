package com.course.pageobjects.linkedin;

import com.course.pageobjects.rozetka.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSignInPage extends BasePage {

    @FindBy(xpath = "//*[@id='username']")
    private WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@class='login__form_action_container ']")
    private WebElement signIn;

    private WebDriver driver;

    public LinkedinSignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    protected void getPage() {
        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
    }

    public LinkedinMainPage signIn(String email, String pass) {
        userName.sendKeys(email);
        password.sendKeys(pass);
        signIn.click();
        return new LinkedinMainPage(driver);
    }
}
