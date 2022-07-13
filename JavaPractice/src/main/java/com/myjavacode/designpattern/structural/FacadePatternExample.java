package com.myjavacode.designpattern.structural;

public class FacadePatternExample {
    public static void main(String[] args) {
        RoomFacade roomFacade = new RoomFacade(new Fan(), new Light());
        roomFacade.openRoom();
        roomFacade.closeRoom();
    }
}

class RoomFacade {
    private Fan fan;
    private Light light;

    RoomFacade (Fan fan, Light light) {
        this.fan = fan;
        this.light = light;
    }

    public void openRoom() {
        fan.start();
        light.on();
    }

    public void closeRoom() {
        fan.stop();
        light.off();
    }
}
class Fan {
    void start() {}
    void stop(){}
}

class Light {
    void on() {}
    void off(){}
}

