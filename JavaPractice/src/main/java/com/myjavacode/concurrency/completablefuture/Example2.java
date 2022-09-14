package com.myjavacode.concurrency.completablefuture;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class Example2 {
    public static void main(String[] args) {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> task("first stage"));
        cf = cf.thenRun(() -> task("second stage"));
        cf = cf.thenRunAsync(() -> task("third stage"));

        cf.join();

        System.out.println("exiting main: " + Thread.currentThread().getName());
    }

    public static void task(String stage) {
        System.out.printf("stage %s , time before task: %s , thread: %s ", stage, LocalTime.now(),
                Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("task " + stage + " done ");
    }
}
