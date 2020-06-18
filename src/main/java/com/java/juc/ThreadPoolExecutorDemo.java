package com.java.juc;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static final int CORE_SIZE = 2;
    public static final int MAX_SIZE = 3;
    public static final int KEEP_ALIVE_TIME = 10;
    public static final int QUEUE_SIZE = 3;
    public static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(QUEUE_SIZE);
    public static void main(String[] args) {

    }

    public static void threadPoolExecutor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_SIZE,
                MAX_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                workQueue);
        //或者
        ExecutorService executorService = new ThreadPoolExecutor(
                CORE_SIZE,
                MAX_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                workQueue);
        //默认使用ThreadPoolExecutor.AbortPolicy，过程中抛出异常
        //异常信息java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@21b8d17c rejected from java.util.concurrent.ThreadPoolExecutor@6433a2[Running, pool size = 2, active threads = 2, queued tasks = 3, completed tasks = 0]
        /*for (int i = 0; i < 7; i ++){
            executor.submit(new RunnableTask());
        }
        //修改拒绝策略
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.DiscardPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 7; i ++){
            //没有异常抛出
            executor.submit(new RunnableTask());
        }
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.DiscardOldestPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 7; i ++){
            //没有异常抛出
            executor.submit(new RunnableTask());
        }
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.CallerRunsPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadFactory(Executors.defaultThreadFactory());
        for (int i = 0; i < 9; i ++){
            //没有异常抛出
            executor.submit(new RunnableTask());
        }*/
        System.out.println("修改线程工厂为自定义工厂：CustomerThreadFactory");
        executor.setThreadFactory(new CustomerThreadFactory());
        for (int i = 0; i < 9; i ++){
            //没有异常抛出
            executor.submit(new RunnableTask());
        }
    }

    public static void scheduledThreadPoolExecutor(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(new RunnableTask(), 10L, TimeUnit.SECONDS);
    }

}
