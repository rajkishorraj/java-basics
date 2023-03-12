package com.myjavacode.concurrency.concurrencyinpractice;

import java.util.Date;

public class ThisEscape {
    private final Integer num;
    //here we are escape thisEscape object without it being fully initialized(in other words)
    //without its constructor getting finish. See below explanation for how
    //let say one thread's creating ThisEscape object and register EventListener object and JVM
    //puts this thread to sleep now another thread calls the onEvent method of eventListener which is already registered
    //but it will get null pointer exception as it num is not yet initialized because JVM unscheduled the first thread
    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {
                    public void onEvent(Event e) {
                        doSomething(e);
                    }
                });
        num = 42;
    }

    private void doSomething(Event e) {
        if (num != 42) {
            System.out.println("Race condition detected at " +
                    new Date());
        }
    }

    public static void main(String[] args) {
        new ThisEscape(new EventSource());
    }
}

class Event {

}

interface EventListener{

}

class EventSource {

    public void registerListener(EventListener eventListener) {

    }
}
