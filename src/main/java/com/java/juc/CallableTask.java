package com.java.juc;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println();
        return null;
    }
}
