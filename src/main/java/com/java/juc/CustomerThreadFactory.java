package com.java.juc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerThreadFactory implements ThreadFactory {
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final String namePrefix = "juc-";

    @Override
    public Thread newThread(Runnable r) {
        //自定义线程名称
        Thread t = new Thread(r, namePrefix + threadNumber.getAndDecrement());
        //设置为守护线程，默认为非守护线程，即用户线程
        //线程优先级为1-10，线程的默认优先级为parent的优先级，值为5
        if (t.isDaemon())
            t.setDaemon(true);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);

        return t;
    }
}
