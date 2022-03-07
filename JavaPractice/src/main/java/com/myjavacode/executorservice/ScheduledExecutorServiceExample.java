package com.myjavacode.executorservice;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main started");

        Runnable task1 = () -> {
            System.out.println("Executing the task1 at: " + LocalDateTime.now() + " -- " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            System.out.println("Executing the task2 at: " + LocalDateTime.now() + " -- " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        LocalDateTime startedTime = LocalDateTime.now();
        System.out.println("Scheduling task to run after 5 seconds... " + LocalDateTime.now());
        ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
//        ScheduledFuture<?> future2 = scheduledExecutorService.scheduleAtFixedRate(task2, 0, 2, TimeUnit.SECONDS);

        System.out.println("Scheduling task to run after 5 seconds started... " + LocalDateTime.now());
////
//        if (LocalDateTime.now()  startedTime.plusSeconds(20)) {
//            future.cancel(true);
//            scheduledExecutorService.shutdown();
//        }

        System.out.println("Thread main finished");
    }
}
