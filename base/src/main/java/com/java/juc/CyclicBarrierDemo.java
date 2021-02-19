package com.java.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    static CyclicBarrier barrier;

    public static void main(String[] args) {
        barrier = new CyclicBarrier(2);
        for (int i = 0; i < 10; i ++){
            (new Thread(new Solver(barrier))).start();
        }
        System.out.println("Mainly things have done");
    }

    static class Solver implements Runnable{
        CyclicBarrier barrier;
        public Solver(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " wake up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

class Solver {
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;
    class Worker implements Runnable {
        int myRow;
        Worker(int row) { myRow = row; }
        public void run() {
//            while (!done()) {
            while (true) {
//                processRow(myRow);
                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }
    }
    public Solver(float[][] matrix) throws InterruptedException {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction = new Runnable() {
            public void run() {
//                mergeRows(...);
            }
        };
        barrier = new CyclicBarrier(N, barrierAction);
        List<Thread> threads = new ArrayList<Thread>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }
        // wait until done
        for (Thread thread : threads)
            //在等待期间让出资源
            thread.join();
    }
}
