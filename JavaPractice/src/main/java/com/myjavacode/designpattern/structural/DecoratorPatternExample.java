package com.myjavacode.designpattern.structural;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Car car = new ColorDecorator(new CarImpl());
        car.create();
    }
}

interface Car {
    void create();
}

class CarImpl implements Car {

    @Override
    public void create() {
        System.out.println("creating car");
    }
}

abstract class CarDecorator implements Car {
    protected Car car;

    CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void create() {
        car.create();
    }

}

class ColorDecorator extends CarDecorator {

    ColorDecorator(Car car) {
        super(car);
    }

    @Override
    public void create() {
        car.create();
        this.setColor();
    }

    public void setColor() {
        System.out.println("setting color");
    }
}