package com.design_pattern.singletion;

/**
 * Created by OY on 2019/11/9.
 */
/*
* 枚举
* Enumeration
* */
public enum  SingletonEnum {
    /*
    * 1.线程安全
    * 2.自动支持序列化，防止反序列化创建新的对象
    * */
    SINGLETON_ENUM;

    public void print(){
        System.out.println("non-static method");
    }

    public static void prints(){
        System.out.println("static method");
    }
}
