package com.java.juc;

import com.java.juc.executor.CustomerRejectPolicy;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static final int CORE_SIZE = 2;
    public static final int MAX_SIZE = 3;
    public static final int KEEP_ALIVE_TIME = 10;
    public static final int QUEUE_SIZE = 3;
    public static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(QUEUE_SIZE);
    public static void main(String[] args) {
        threadPoolExecutor();
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
        /*setAbortPolicy(executor);
        submitTask(executor);

        //修改拒绝策略
        setDiscardPolicy(executor);
        //没有异常抛出
        submitTask(executor);

        setDiscardOldestPolicy(executor);
        //没有异常抛出
        submitTask(executor);

        setCallerRunsPolicy(executor);
        //没有异常抛出
        submitTask(executor);*/

        setCustomerPolicy(executor);
        submitTask(executor);

        /*System.out.println("修改线程工厂为自定义工厂：CustomerThreadFactory");
        executor.setThreadFactory(new CustomerThreadFactory());
        submitTask(executor);*/
    }

    public static void setAbortPolicy(ThreadPoolExecutor executor){
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.AbortPolicy()");
        //该拒绝策略会中断调用者的处理过程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    }
    public static void setDiscardPolicy(ThreadPoolExecutor executor){
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.DiscardPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
    }
    public static void setDiscardOldestPolicy(ThreadPoolExecutor executor){
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.DiscardOldestPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
    }
    public static void setCallerRunsPolicy(ThreadPoolExecutor executor){
        System.out.println("修改拒绝策略为：ThreadPoolExecutor.CallerRunsPolicy()");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadFactory(Executors.defaultThreadFactory());
    }
    public static void setCustomerPolicy(ThreadPoolExecutor executor){
        System.out.println("修改拒绝策略为自定义策略");
        executor.setRejectedExecutionHandler(new CustomerRejectPolicy());
        executor.setThreadFactory(Executors.defaultThreadFactory());
    }

    public static void submitTask(ThreadPoolExecutor executor){
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
