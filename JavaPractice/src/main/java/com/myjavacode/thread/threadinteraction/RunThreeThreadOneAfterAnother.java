package com.myjavacode.thread.threadinteraction;

public class RunThreeThreadOneAfterAnother {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunnableOne(), "T1");
        Thread t2 = new Thread(new RunnableTwo(), "T2");
        Thread t3 = new Thread(new RunnableThree(), "T3");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println("Main Thread Finished");
    }
}

class RunnableOne implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " selected for execution ");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + " Finished execution ");

    }
}

class RunnableTwo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " selected for execution ");
        for (int i = 5; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + " Finished execution ");

    }
}

class RunnableThree implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " selected for execution ");
        for (int i = 10; i < 15; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName() + " Finished execution ");

    }
}

