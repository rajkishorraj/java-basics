package com.myjavacode.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(
                () -> {
                    System.out.println("task done- " + Thread.currentThread().getName());
                    System.out.println("2");
                });
//        cf.join(); //returns result once task completes or throw uncheck exception

        cf.get(); //waits for task to be completed throws checked exception

        System.out.println("Exiting main thread - " + Thread.currentThread().getName());
    }
}
