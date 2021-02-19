package com.design_pattern.singletion;

/**
 * Created by OY on 2019/11/9.
 */
/*
* 静态内部类
* */
public class SingletonStaticInnerClass {
    private SingletonStaticInnerClass(){}

    /*
    * 利用classloader机制保证只有一个线程初始化实例
    *   SingletonStaticInnerClass被装载时不一定被实例化，通过getSaveInstance才会显示装载SingletonHolder类
    *   从而实例化SingletonStaticInnerClass ssic
    * */
    private static class SingletonHolder{
        private final static SingletonStaticInnerClass ssic = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getSaveInstance(){
        return SingletonHolder.ssic;
    }
}
