package com.java.java8inaction.chap2.javaapi;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 16:25
 * @Description: Lambda替换Java API中的匿名表达式接口
 *
 * @FunctionalInterface
 * public interface Runnable {
 *      public abstract void run();
 * }
 */
public class RunnableDemo {

    public static void main(String[] args) {
        //使用Runnable执行代码块
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        });

        //使用Lambda表达式执行代码块
        Thread tl = new Thread(() -> {
            System.out.println("Hello Lambda");
        });
    }
}
