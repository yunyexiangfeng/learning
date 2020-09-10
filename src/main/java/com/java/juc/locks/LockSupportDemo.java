package com.java.juc.locks;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    @Test
    public void test() throws InterruptedException {
//        lockSupportDemo();
        lockSupportDemo2();
    }
    public void lockSupportDemo() throws InterruptedException {
//        Thread t1 = new Thread(LockSupport::park);
        //此处可以直接使用Java8的方法引用，但是为了使用日志体现效果，使用lambda实现
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " before park");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " after park");

        });
        t1.setName("t1");
        t1.start();

        //休眠3s体现线程t1的park状态
        Thread.sleep(3000);
        LockSupport.unpark(t1);
    }

    /**
     * unpark发生在park之前，被park的线程依然可以正常退出
     * 原因：
     *  _counter = 1 有许可
     *  _counter = 0 没有许可
     *  C语言源码层面，LockSupport通过_counter实现线程阻塞
     *  当unpark时，_counter会置为1
     *  当park时，尝试获取许可，判断_counter值为1则说明已经被unpark过，直接继续执行，不会阻塞。否则置为0
     * @throws InterruptedException
     */
    public void lockSupportDemo2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " before park");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " after park");
        });
        t1.setName("t1");
        t1.start();
        //先执行unpark操作
        System.out.println("unpark t1 thread");
        LockSupport.unpark(t1);
        //休眠4s，等待t1执行结束
        Thread.sleep(4000);
    }
}
