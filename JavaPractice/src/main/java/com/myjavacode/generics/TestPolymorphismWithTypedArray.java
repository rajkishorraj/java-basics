package com.myjavacode.generics;

import java.util.List;

public class TestPolymorphismWithTypedArray {

    public static void main(String [] args) {
        Bird [] birds = {new Bird(), new Bird()};
        Dog [] dogs = { new Dog(), new Dog()};

        new AnimalDoctor().checkAnimals(birds);
        new AnimalDoctor().checkAnimals(dogs);

        addAnimals(birds); //will throw array store exception at runtime

    }

    static void addAnimals(Animal [] animals) {
        animals[0] = new Dog();
    }

}

abstract class Animal {
    abstract void checkUp();
}

class AnimalDoctor {

    void checkAnimals (Animal [] animals) {
        for (Animal animal : animals) {
            animal.checkUp();
        }
    }

    //will only allow Animal generic type
    void addAnimals(List<Animal> animals) {
        animals.add(new Dog());
    }

    //super allow any generic type of Animal or its super type
    void addAnimalsWithSuper(List<? super Animal> animals) {
        animals.add(new Dog());
    }

    //will allow any subtype of Animal
    void checkAnimals(List<? extends Animal> animals) {
//        animals.add(new Dog());//will give error
        for (Animal animal : animals) {
            animal.checkUp();
        }
    }
}

class Bird extends Animal {

    @Override
    void checkUp() {
        System.out.println("Birds Check up");
    }
}

class Dog extends Animal {

    @Override
    void checkUp() {
        System.out.println("Dog Check up");
    }
}

class Cat extends Animal {

    @Override
    void checkUp() {
        System.out.println("Cat Check up");
    }
}


