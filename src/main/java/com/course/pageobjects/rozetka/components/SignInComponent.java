package com.course.pageobjects.rozetka.components;

import com.course.pageobjects.BaseComponent;
import com.course.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInComponent extends BaseComponent {

    @FindBy(xpath = "//*[@formcontrolname='login']")
    private WebElement email;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@class='button button--large button--green auth-modal__submit']")
    private WebElement signIn;
    private WebDriver driver;

    public SignInComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signIn.click();
    }
}
