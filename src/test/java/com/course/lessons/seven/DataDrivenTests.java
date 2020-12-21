package com.course.lessons.seven;

import org.testng.annotations.Test;

public class DataDrivenTests {

    @Test(dataProvider = "data-provider3", dataProviderClass = DataProviderContainer.class)
    public void testingData(String message, int value) {
        System.out.println(message + value);
    }
}
