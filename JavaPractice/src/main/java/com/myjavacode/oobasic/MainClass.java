package com.myjavacode.oobasic;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void checkObject() {
        Animal horseObj = new Horse("horse");
        Animal horse2Obj = new Horse("horse");
        Map<Animal, String> mp = new HashMap<>();
        mp.putIfAbsent(horseObj, "horse");

        System.out.println(mp.getOrDefault(new Horse("horse"), "no horse"));

        String horse = new String("horse").intern();
        String horse2 = new String("horse").intern();

        System.out.println(horse == horse2);


    }

    public static void checkPrimitives() {
        Integer a = 10;

        assert true;

        System.out.println(a);


    }
    public static void main(String [] args) {
//        Animal horse = new Horse("horse");
//        horse.eat();
//        checkObject();
        checkPrimitives();



//        UseAnimals useAnimals = new UseAnimals();
//        Animal animal = new Animal();
//        Horse horse1 = new Horse();
//        Animal animal1 = new Horse();
//        useAnimals.doStuff(animal);
//        useAnimals.doStuff(horse1);
//        useAnimals.doStuff(animal1);

//        Animal1 animal1 = new Animal1("frida");
//        System.out.println(animal1.getName());
//        Animal1 animal11 = new Animal1();
//        System.out.println(animal11.getName());
//        String x = "dfs";
//        x = "x";
//        System.out.println(x + "dfs");



    }
}
