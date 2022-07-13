package com.myjavacode.designpattern.creational;

public class AbstractCarFactory {

    public static Car buildCar(CarType carType) {
        FactorLocation factorLocation = FactorLocation.INDIA;

        switch (factorLocation) {
            case INDIA:
                return IndiaFactory.getCar(carType);
            case USA:
                return USAFactory.getCar(carType);
            default:
                return null;
        }
    }
}

enum FactorLocation {
    INDIA, USA;
}

class IndiaFactory {
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

}

class USAFactory {
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

}

