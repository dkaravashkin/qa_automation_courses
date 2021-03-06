package com.course.lessons.ui;

import com.course.lessons.BaseTest;
import com.course.pageobjects.rozetka.pages.CheckoutPage;
import com.course.pageobjects.rozetka.pages.RozetkaNotebooksPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RozetkaTest extends BaseTest {

    @Test
    public void loginTest() {
        rozetkaHomePage.getPage();
        rozetkaHomePage.pressLogin();
        rozetkaHomePage.signInComponent.login(userName, password);
        System.out.println("User Name: " + userName + " " + "Password: " + password);
    }

/*    @Test
    public void buySmth() throws InterruptedException {
        rozetkaHomePage.getPage();
        RozetkaNotebooksPage rozetkaNotebooksPage = rozetkaHomePage.openNotebooksCategory();
        rozetkaNotebooksPage.filterProducts();
        rozetkaNotebooksPage.selectMacBook();
        rozetkaNotebooksPage.productComponent.buyProduct();
        CheckoutPage checkoutPage = rozetkaNotebooksPage.basketComponent.clickSubmitButton();
        Assert.assertEquals("Оформлення замовлення", checkoutPage.getCheckoutHeading());
    }*/
}
