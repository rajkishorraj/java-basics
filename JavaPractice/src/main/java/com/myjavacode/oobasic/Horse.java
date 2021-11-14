package com.myjavacode.oobasic;

public class Horse extends Animal {

    private String name;
    public Horse() {
        System.out.println("inside horse no arg constructor");
    }

    public Horse(String name) {
        super(name);
        this.name = name;
        System.out.println("inside horse arg constructor");
    }
    public void eat() {
        super.eat();
        System.out.println("Horse eat grass");
    }
}
