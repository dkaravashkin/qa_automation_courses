package com.course.lessons.seven;

import org.testng.annotations.DataProvider;

public class DataProviderContainer {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"My data: ", 10}, {"My data: ", 100}};
    }

    @DataProvider(name = "data-provider2")
    public Object[][] dataProviderMethod2() {
        return new Object[][]{{"My data: ", 10}, {"My data: ", 100}};
    }

    @DataProvider(name = "data-provider3")
    public Object[][] dataProviderMethod3() {
        return new Object[][]{{"My data: ", 10}, {"My data: ", 100}};
    }
}
