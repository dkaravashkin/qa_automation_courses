package com.course.lessons.ui;

import com.course.lessons.BaseTest;
import com.course.pageobjects.linkedin.LinkedinMainPage;
import com.course.pageobjects.linkedin.LinkedinSignInPage;
import org.testng.annotations.Test;

public class LinkedinTest extends BaseTest {

    @Test
    public void signInTest() {
        linkedinHomePage.getPage();
        LinkedinSignInPage linkedinSignInPage = linkedinHomePage.clickSignIn();
        LinkedinMainPage linkedinMainPage = linkedinSignInPage.signIn(userName, password);
        linkedinMainPage.assertMessagingIsPresent();
//        Assert.assertTrue(linkedinMainPage.isMessagingPresent());
    }
}
