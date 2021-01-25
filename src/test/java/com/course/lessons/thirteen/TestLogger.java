package com.course.lessons.thirteen;

import com.course.lessons.BaseTest;
import com.course.lessons.nine.MvnTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLogger extends BaseTest {
    private static Logger logger = LogManager.getLogger(TestLogger.class);

    @Test
    public void test() {
        logger.debug("This is debug log lvl");
        logger.info("This is info log lvl");
        logger.error("This is error log lvl", new NullPointerException("This is my exception"));
    }
}
