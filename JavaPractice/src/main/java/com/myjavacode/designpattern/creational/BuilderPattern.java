package com.myjavacode.designpattern.creational;

import lombok.Getter;

public class BuilderPattern {

    public static void main(String[] args) {
        Vehicle vehicle =  new Vehicle.VehicleBuilder().build();
    }
}

@Getter
class Vehicle {
    private String name;
    private int launchedYear;

    private Vehicle (VehicleBuilder vehicleBuilder) {
        this.name = vehicleBuilder.name;
        this.launchedYear = vehicleBuilder.launchedYear;;
    }


    public static class VehicleBuilder {

        private String name;
        private int launchedYear;

        public VehicleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public VehicleBuilder setLaunchedYear(int launchedYear) {
            this.launchedYear = launchedYear;
            return this;
        }

        public Vehicle build () {
            return new Vehicle(this);
        }
    }

}
