package com.design_pattern.singletion;

/**
 * Created by OY on 2019/11/8.
 */
/*
* 饿汉模式
* */
public class SingletonHungry {
    private SingletonHungry(){}
    /*
    * 类加载时即实例化
    * 优点：
    *       1.线程安全，classloader在装载该类时会直接实例化
    *       2.相对于synchronized效率更高
    * 缺点：
    *       1.可能不会使用。
    *       2.非延迟加载--如果SingletionHungry很耗时，显示
    * */
    private static SingletonHungry sh = new SingletonHungry();

    public static SingletonHungry getSaveInstance(){
        return sh;
    }
}
