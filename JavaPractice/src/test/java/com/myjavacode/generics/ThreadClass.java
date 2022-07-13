package com.myjavacode.generics;

public class ThreadClass extends Thread {
    public static ThreadClass threadClass;

    public void run() {
        System.out.println("thread class run");
        ThreadClass.threadClass.notify();
    }
    public static void main(String[] args) {
        threadClass = new ThreadClass();

//        Runnable runnable = () -> {
//            System.out.println("runnable");
//            try {
//                threadClass.wait();
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//            System.out.println("waiting end");
//        };

        Thread t1 = new Thread(new ThreadClass());
//        Thread t2 = new Thread(runnable);
        t1.start();
//        t2.start();

        System.out.println("main method ended");


    }

}
