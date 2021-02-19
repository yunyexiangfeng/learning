package com.java.juc.future;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        //real data
        RealData realData = new RealData();

        //future
        FutureTask<String> task = new FutureTask<>(realData);
        //send request and get future data
        es.submit(task);
        try {
            //get method will block, waiting the call method return real data
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //shut down thread pool
        es.shutdown();
    }
}
