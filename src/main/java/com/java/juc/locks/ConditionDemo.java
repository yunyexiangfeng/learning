package com.java.juc.locks;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    @Test
    public void test() throws InterruptedException {
        conditionDemo();
    }

    public void conditionDemo() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("before condition await");
                //await时需获取锁，同wait
                condition.await();
                System.out.println("after condition await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.setName("t1");
        t1.start();

        Thread.sleep(1000);
        System.out.println("main thread signal t1 thread");
        lock.lock();
        //signal时需获取锁，同notify
        condition.signal();
        lock.unlock();
    }
}
