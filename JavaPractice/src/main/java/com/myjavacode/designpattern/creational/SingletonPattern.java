package com.myjavacode.designpattern.creational;

public class SingletonPattern {
    public static SingletonPattern singletonPattern = null;
    private SingletonPattern() {}
    public SingletonPattern getSingletonPattern () {
        return singletonPattern == null ? new SingletonPattern() : singletonPattern;
    }
}
