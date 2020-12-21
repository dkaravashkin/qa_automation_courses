package com.course.lessons.seven;

public class Debug {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 5;
        array[2] = 10;
        array[3] = 15;
        array[4] = 20;
        array[5] = 25;
        array[6] = 30;
        array[7] = 35;

        for (int value: array) {
            System.out.println(value);
        }
    }
}
