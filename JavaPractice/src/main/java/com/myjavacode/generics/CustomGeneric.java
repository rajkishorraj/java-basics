package com.myjavacode.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomGeneric<T, U> {
    private T name;
    private U age;

    public void detail() {
        System.out.println(getName() + " " + getAge());
    }

    public <X> void show(X x) {
        System.out.println(x);
    }


    public static void main(String [] args) {
        CustomGeneric<String, Integer> customGeneric = new CustomGeneric<>("raj", 23);
        customGeneric.detail();
        customGeneric.show(5);
    }

}
