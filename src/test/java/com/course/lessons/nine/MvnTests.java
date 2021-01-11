package com.course.lessons.nine;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MvnTests {
    @Parameters({"first-name"})
    @Test
    public void testOne(String firstName) {
        long threadId = Thread.currentThread().getId();
        System.out.println("First test thread: " + threadId);
        Assert.assertEquals(2, 2);
    }

    @Test
    public void testTwo() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Second test thread: " + threadId);
        Assert.assertEquals(5, 5);
    }

    @Test
    public void testThree() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Third test thread: " + threadId);
        Assert.assertEquals(7, 8);
    }
}
