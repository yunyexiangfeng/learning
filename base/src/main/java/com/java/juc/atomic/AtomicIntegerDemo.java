package com.java.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private final static int THREAD_COUNT = 100;
    private static int sum = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i ++){
            Thread thread = new Thread(() -> {
                //自增为非原子性操作，在jvm层面表现为两条指令
                sum ++;
                System.out.println("sum : " + sum);
            });
            thread.start();
        }

        for (int i = 0; i < THREAD_COUNT; i ++){
            Thread thread = new Thread(() -> {
                atomicInteger.incrementAndGet();
                System.out.println("atomicInteger : " + atomicInteger.get());
            });
            thread.start();
        }
    }
}
