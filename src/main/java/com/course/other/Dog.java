package com.course.other;

public class Dog extends Animal implements Action {

    // public , package-private , private, protected
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    //Static polymorphism (Method overloading)

    public void display(String name) {
        System.out.println(name);
    }

    public void display(String name, String age) {
        System.out.println(name + age);
    }

    public void display(String name, String age, String sex) {
        System.out.println(name + age + sex);
    }

    // Dynamic polymorphism (Method overriding)

    @Override
    public void voice() {
        System.out.println("Say gav");
    }

    @Override
    public void walk() {
        System.out.println("Dog can walk");
    }

    @Override
    public void jump() {
        System.out.println("Dog can jump");
    }
}
