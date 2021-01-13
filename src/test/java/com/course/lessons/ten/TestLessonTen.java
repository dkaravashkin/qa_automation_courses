package com.course.lessons.ten;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Epic("This is my epic")
@Feature("This is my feature")
public class TestLessonTen extends BaseTest {
    private Properties props;

    @BeforeSuite
    public void setup() throws IOException {
        props = new Properties();
        props.load(new FileInputStream("C:\\repos\\qa_automation_courses\\src\\main\\resources\\" + System.getProperty("ENV") + ".properties"));
    }

    @Test
    @Owner("Dima")
    @Severity(SeverityLevel.CRITICAL)
    @Story("This test have random assert")
    @Description("Random assert test one")
    public void TestOne() {
        props.setProperty("secondName", "Mike");
        System.out.println(props.getProperty("url"));
        System.out.println(props.getProperty("userName"));
        System.out.println(props.getProperty("password"));
        System.out.println(props.getProperty("secondName"));
        Assert.assertEquals(5, 5);
    }

    @Test
    @Owner("Yana")
    @Severity(SeverityLevel.BLOCKER)
    @Story("This test validates linkedin login page")
    @Description("Linkedin test")
    @Issue("JRASERVER-3374")
    public void linkedinTest() {
        linkedinLoginPage.getPage();
        linkedinLoginPage.login("Test", "Test");
    }

    @Test
    @Owner("Natalia")
    @Severity(SeverityLevel.MINOR)
    @Story("This test have random assert")
    @Description("Random assert test three")
    public void TestThree() {
        props.setProperty("secondName", "Mike");
        Assert.assertEquals(1, 1);
    }
}
