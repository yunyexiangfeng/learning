package com.java.java8inaction.chap3.functioninterface;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/25 11:07
 * @Description: default
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        //lambda表达式
        Runnable r1 = () -> {
            System.out.println("Hello world 1");
        };

        //匿名类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        //process
        process(r1);
        process(r2);
        //直接传递lambda表达式
        process(() -> {
            System.out.println("Hello world 3");
        });

    }

    private static void process(Runnable r){
        r.run();
    }
}
