package com.myjavacode.designpattern.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPatternExample {
    //Simply put, the flyweight pattern is based on a factory which recycles created objects by
    // storing them after creation
    // . Each time an object is requested, the factory looks up the object in order to check if
    // it's already been created. If it has, the existing object is returned – otherwise, a new
    // one is created, stored and then returned.

    public static void main(String[] args) {
        Vehicle ferrari = VehicleFactory.getVehicle("red");
    }

}

class VehicleFactory {
    private static final Map<String, Vehicle> vehicleHashMap=  new HashMap<>();

    public static Vehicle getVehicle(String color) {
        Vehicle newVehicle = vehicleHashMap.computeIfAbsent(color, colorVariable ->
                new Ferrari(color));
        return newVehicle;
    }

}

interface Vehicle {
    void start();
    void stop();
}


final class Ferrari implements Vehicle {
    private final String color;

    Ferrari(String color) {
        this.color = color;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}