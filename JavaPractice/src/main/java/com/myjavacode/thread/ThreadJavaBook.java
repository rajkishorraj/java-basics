package com.myjavacode.thread;

public class ThreadJavaBook {
     public static void main(String[] args) {
         Runnable r = () -> {
             System.out.println("Learning threading");
             System.out.println("Executed by thread: " + Thread.currentThread().getName());
         };

         synchronized (ThreadJavaBook.class) {
             int a = 5;
         } //synchronizeding on class instance

         Thread thread = new Thread(r);
         thread.setName("First Thread");
         thread.start();

    }
}
