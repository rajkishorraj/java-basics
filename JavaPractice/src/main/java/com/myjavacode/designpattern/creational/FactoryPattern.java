package com.myjavacode.designpattern.creational;

enum CarType {
    HERO, MARUTI;
}
public class FactoryPattern {

    public static Car getCar(CarType carType) {

        switch (carType) {
            case HERO:
                return new Hero();
            case MARUTI:
                return new Maruti();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Car newCar = FactoryPattern.getCar(CarType.HERO);
    }
}

abstract class Car {
    public void power() {

    }
}

 class Hero extends Car {
    public void power () {
        System.out.println("High power");
    }
}
 class Maruti extends Car {
    public void power () {
        System.out.println("Medium power");
    }
}
