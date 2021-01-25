package com.course.pageobjects.rozetka.pages;

import com.course.pageobjects.rozetka.components.BasketComponent;
import com.course.pageobjects.rozetka.components.SignInComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaHomePage extends BasePage {

    @FindBy(xpath = "//*[@class='header-topline__user-link button--link']")
    private WebElement signIn;

    @FindBy(xpath = "//*[@class='menu-categories__link' and @href='https://rozetka.com.ua/ua/computers-notebooks/c80253/']")
    private WebElement notebooksCategory;

    @FindBy(xpath = "//*[@class='menu__hidden-title' and @href='https://rozetka.com.ua/ua/notebooks/c80004/']")
    private WebElement hidenNotebooksCategory;
    public SignInComponent signInComponent;
    public BasketComponent basketComponent;
    private WebDriver driver;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        signInComponent = new SignInComponent(driver);
        basketComponent = new BasketComponent(driver);
    }

    @Override
    public void getPage() {
        driver.get("https://rozetka.com.ua/");
    }

    public void pressLogin() {
        waitUtils.waitUntilElementClickable(signIn, 10);
        signIn.click();
    }

    public RozetkaNotebooksPage openNotebooksCategory() {
        waitUtils.waitUntilElementClickable(notebooksCategory, 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(notebooksCategory).build().perform();
        waitUtils.waitUntilElementClickable(hidenNotebooksCategory, 10);
        hidenNotebooksCategory.click();
        return new RozetkaNotebooksPage(driver);
    }
}
