package com.design_pattern.singletion;

/**
 * Created by OY on 2019/11/8.
 */
/*
* 懒汉模式
*
* */
public class SingletonLazy {

    private static SingletonLazy sl;

    private SingletonLazy(){}

    /*
    * 非线程安全
    * */
    public static SingletonLazy getInstance(){
        //延迟到使用时实例化
        if (sl == null){
            sl = new SingletonLazy();
        }
        return sl;
    }
    /*
     * 优点
     *      线程安全
     * 缺点：
     *      1.synchronized 每次调用都需要加锁，事实上只需要第一次实例化时加锁，
     *      降低效率
     * */
    public static synchronized SingletonLazy getSaveInstance(){
        //延迟到使用时实例化
        if (sl == null){
            sl = new SingletonLazy();
        }
        return sl;
    }

}
