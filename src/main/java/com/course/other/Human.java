package com.course.other;

public class Human {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be below 0");
        } else {
            this.age = age;
        }
    }
}
