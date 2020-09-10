package com.java.juc.locks;

import org.junit.Test;


public class ObjectDemo {
    final Object lock = new Object();
    @Test
    public void test() throws InterruptedException {
        this.objectDemo();
    }
    public void objectDemo() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " starts");
                    Thread.sleep(100000);
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " been notified");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " starts");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " been notified");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //设置线程名称，确定线程启动顺序
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        //休眠一秒，等待t1和t2线程启动完毕
        Thread.sleep(100000);

        System.out.println("main thread notify one of the t1/t2");
        synchronized (lock){
            //当对象的等待队列有多个线程时，notify方法会通知对头的线程
            //无法做到唤醒指定线程
            lock.notify();
            //无差别唤醒所有等待队列中的线程
//            lock.notifyAll();
        }
        System.out.println("notified");

        //休眠10秒，防止主线程关闭导致的t1/t2关闭
        //从而模拟当t1或者t2被唤醒后，有一个线程还是wait状态
        System.out.println("t1 state : " + t1.getState());
        System.out.println("t2 state : " + t2.getState());
        Thread.sleep(10000);
        System.out.println("t1 state : " + t1.getState());
        System.out.println("t2 state : " + t2.getState());
    }
}
