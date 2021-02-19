package com.java.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBoolean demo
 * 1.using AtomicBoolean, only one thread can go to work
 * 2.using boolean, maybe on or more thread can go to work
 */
public class AtomicBooleanDemo {

    private final static int THREAD_COUNT = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
    private static boolean flag = true;
    private static AtomicBoolean atomicFlag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i ++){
            Thread thread = new Thread(new A(countDownLatch));
            thread.start();
        }
        countDownLatch.await();
        countDownLatch = new CountDownLatch(THREAD_COUNT);
        System.out.println("===============split=================");
        for (int i = 0; i < THREAD_COUNT; i ++){
            Thread thread = new Thread(new B(countDownLatch));
            thread.start();
        }
        countDownLatch.await();
        System.out.println("finish test");
    }
    private static class A implements Runnable{
        public CountDownLatch countDownLatch ;
        public A(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (atomicFlag.compareAndSet(true, false)){
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " work");
            }else {
                System.out.println(Thread.currentThread().getName() + " not word");
            }
            countDownLatch.countDown();
        }
    }
    private static class B implements Runnable{
        public CountDownLatch countDownLatch ;
        public B(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (flag){
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " work");
                flag = false;
            }else {
                System.out.println(Thread.currentThread().getName() + " not work");
            }
            countDownLatch.countDown();
        }
    }
}
