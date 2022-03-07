package com.myjavacode.generics;

import java.util.ArrayList;
import java.util.List;

public class TestPolymorphismWithTypedCollection {

    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Bird());
        birds.add(new Bird());
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Bird());
        animals.add(new Dog());

        //Can't pass list of object with generic type as subtype
        //in a method that accepts list of object with generic type as super type
        //because we might send one subtype and inside method we can add different subtype
        //compiler has no way of knowing it and JVM at runtime does not anything about type
        //because type gets erased at type eraser step during compilation
//        new AnimalDoctor().addAnimals(birds);

        //however we can pass subtype if we promise we won't add anything
        //we will have to add wildcard ? to method argument.
        new AnimalDoctor().checkAnimals(dogs);

//        List<Integer> integers = new ArrayList<>();
//        add(integers);
    }

    static void add(List<Object> list) {
        list.add(new Dog());
    }
}

