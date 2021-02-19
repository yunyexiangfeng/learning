package com.java.java8inaction.chap2.javaapi;

import com.google.common.base.Function;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 16:28
 * @Description: Lambda替换Java API中的匿名表达式接口
 * //java.util.concurrent.Callable
 * @FunctionalInterface
 * public interface Callable<V> {
 *      V call()throws Exception;
 *}
 *
 */
public class CallableDemo {
    public static void main(String[] args) {

        //Create thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //通过Callable返回结果
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        //通过Lambda表达式返回结果
        executorService.submit(() -> Thread.currentThread().getName());

    }
}
