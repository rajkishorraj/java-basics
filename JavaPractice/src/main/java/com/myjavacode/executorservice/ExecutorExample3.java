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

public class ExecutorExample3 {

    public String work(String requestNumber) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();

        callables.add(() -> {
            Thread.sleep(3000);
            System.out.println("task 1 printing for request number -- " + requestNumber + "--thread-- " + Thread.currentThread().getName() + " ---- " + Math.random() * 10);
            return "Task 1 thread number " + requestNumber;
        });
        callables.add(() -> {
            Thread.sleep(2000);
            System.out.println("task 2 printing for request number -- " + requestNumber + "--thread-- " + Thread.currentThread().getName() + " ---- " + Math.random() * 10);
            return "Task 2 thread number " + requestNumber;
        });
        callables.add(() -> {
            Thread.sleep(1000);
            System.out.println("task 3 printing for request number -- " + requestNumber + "--thread-- " + Thread.currentThread().getName() + " ---- " + Math.random() * 10);
            return "Task 3 thread number " + requestNumber;
        });


        List<Future<String>> resultList = new ArrayList<>();

        for (Callable<String> callable : callables) {
            Future<String> future = executor.submit(callable);
            resultList.add(future);
        }

        executor.shutdown();

        System.out.println("\n========Printing the results====== for thread number -- " + requestNumber);

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

//        Thread.sleep(2000);

        return "finished " + Math.random()*100 + "--thread-- " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newFixedThreadPool(2);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> new ExecutorExample3().work("1st")); //request 1
        callables.add(() -> new ExecutorExample3().work("2nd")); //request 2
        callables.add(() -> new ExecutorExample3().work("3rd")); //request 3
        callables.add(() -> new ExecutorExample3().work("4th")); //request 4

        List<Future<String>> resultList = new ArrayList<>();


        for (Callable<String> callable : callables) {
            Future<String> future = executor1.submit(callable);
            resultList.add(future);
        }

        executor1.shutdown();

        for (int i = 0; i < resultList.size(); i++) {
            Future<String> future = resultList.get(i);
//            System.out.println("result for thread " + i+1 + "--thread-- " + Thread.currentThread().getId());
            try {
                Instant start1 = Instant.now();
                String result = future.get();
                Instant end1 = Instant.now();
                System.out.println("result " + result + " " + Duration.between(start1, end1).toNanos());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
