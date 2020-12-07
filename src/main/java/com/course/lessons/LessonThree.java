package com.course.lessons;

import com.course.other.Cat;
import com.course.other.Dog;

public class LessonThree {
    Dog dogJack = new Dog("Jack");
    Dog dogMax = new Dog("Max");
    Cat cat = new Cat();

    public static void message(String message) {
        System.out.println("Hello World");
    }

    public static String message2(String message) {
        return message + " World";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println("Hello World");
        }
        int j = 6;

        while (j > 0) {
            System.out.println("Hello World");
            j--;
        }

        int f = -6;

        do {
            System.out.println("Hello World");
            f--;
        } while (f > 0);

        // 1 , 2 , 3 , 4 , 5
        // 0 , 1 , 2 , 3 , 4
        int[] intArray = new int[5];
        intArray[0] = 1;
        intArray[1] = 10;
        intArray[2] = 100;
        intArray[3] = 1000;
        intArray[4] = 10000;

        int[] newIntArray = {1, 10, 100, 10000, 100000};

        for (int i = 0; i < newIntArray.length; i++) {
            System.out.println(newIntArray[i]);
        }

        for (int value : newIntArray) {
            System.out.println(value);
        }

        for (int i = 0; i < 9; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }

        for (int i = 0; i < 9; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }

        message("Hello World");
        System.out.println(message2("Hello"));
    }
}
