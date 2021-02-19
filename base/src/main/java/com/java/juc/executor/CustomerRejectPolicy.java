package com.java.juc.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomerRejectPolicy implements RejectedExecutionHandler {
    public CustomerRejectPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("do something");
    }
}
