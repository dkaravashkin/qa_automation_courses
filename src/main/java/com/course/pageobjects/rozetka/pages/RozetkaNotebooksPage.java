package com.course.pageobjects.rozetka.pages;

import com.course.pageobjects.BasePage;
import com.course.pageobjects.rozetka.components.BasketComponent;
import com.course.pageobjects.rozetka.components.ProductComponent;
import com.course.pageobjects.rozetka.components.SignInComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaNotebooksPage extends BasePage {
    public ProductComponent productComponent;

    @FindBy(xpath = "//*[@class='checkbox-filter__link' and @href='/ua/notebooks/c80004/producer=apple/']")
    private WebElement filter;

    @FindBy(xpath = "//*[@class='goods-tile__picture' and @href='https://rozetka.com.ua/ua/apple_mvvk2ua_a/p191882160/']")
    private WebElement appleMacBook;
    private WebDriver driver;

    public RozetkaNotebooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        productComponent = new ProductComponent(driver);
    }

    @Override
    public void getPage() {
        driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");
    }

    public void filterProducts() {
        waitUntilElementVisible(filter, 10);
        filter.click();
    }

    public void selectMacBook() {
        waitUntilElementClickable(appleMacBook, 10);
        appleMacBook.click();
    }
}
