package com.java.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    static final int N = 10;
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        System.out.println("Main count down");            // don't let run yet
        Thread.sleep(3000);
        startSignal.countDown();      // let all threads proceed
        System.out.println("Main waiting worker to count down");
        doneSignal.await();           // wait for all to finish
        System.out.println("Main done");
    }
}
/*class Driver {
    void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish
    }
}*/
class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal){
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    @Override
    public void run() {
        try {
            //等到主线程执行到某个地方时开始执行worker线程的run方法
            startSignal.await();
            System.out.println(Thread.currentThread().getName() + " running");
            doneSignal.countDown();
        } catch (InterruptedException ex) {} // return;
    }
}