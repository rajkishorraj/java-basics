package com.myjavacode.executorservice;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();

        callables.add(() -> task("task 1"));
        callables.add(() -> task("task 2"));
        callables.add(() -> task("task 3"));

        List<Future<String>> resultList = null;

        Instant start = Instant.now();
        try {
            resultList = executor.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();

        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken in starting all tasks execution: "+ timeElapsed.toMillis() +" milliseconds "
        + Thread.currentThread().getName());

        executor.shutdown();

        System.out.println("\n========Printing the results======");

        for (int i = 0; i < resultList.size(); i++) {
            Future<String> future = resultList.get(i);
            try {
                String result = future.get();
                System.out.println("result of task " + i + " " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static String task(String taskName) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("printing task " + taskName + " " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return "taskName";
    }
}
