package com.course.other;

public class Cat extends Animal implements Action {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void catTailWagging() {
        tailWagging();
    }

    @Override
    public void voice() {
        System.out.println("Say myau");
    }

    public void walk() {
        System.out.println("Cat can walk");
    }

    public void jump() {
        System.out.println("Cat can jump");
    }

    enum Color {
        RED,
        BLACK,
        GREY,
        WHITE
    }
}
