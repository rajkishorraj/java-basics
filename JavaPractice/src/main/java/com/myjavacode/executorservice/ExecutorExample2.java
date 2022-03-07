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

public class ExecutorExample2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();

        callables.add(() -> {
            Thread.sleep(3000);
            System.out.println("task printing1" + Math.random() * 10);
            return "Task 1";
        });
        callables.add(() -> {
            Thread.sleep(3000);
            System.out.println("task printing2" + Math.random() * 10);
            return "Task 2";
        });
        callables.add(() -> {
            Thread.sleep(3000);
            System.out.println("task printing3" + Math.random() * 10);
            return "Task 3";
        });


        List<Future<String>> resultList = new ArrayList<>();

        Instant start = Instant.now();

       for (Callable<String> callable : callables) {
           Future<String> future = executor.submit(callable);
           resultList.add(future);
       }

        Instant end = Instant.now();

        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        executor.shutdown();

        System.out.println("\n========Printing the results======");

        for (int i = 0; i < resultList.size(); i++) {
            Future<String> future = resultList.get(i);
            try {
                Instant start1 = Instant.now();
                String result = future.get();
                Instant end1 = Instant.now();
                System.out.println("result " + result + " " + Duration.between(start1, end1).toMillis());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
