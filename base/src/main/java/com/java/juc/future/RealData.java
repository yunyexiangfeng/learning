package com.java.juc.future;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {
    /**
     * 构造Real Data并返回
     * 耗时操作
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "hello future";
    }
}
