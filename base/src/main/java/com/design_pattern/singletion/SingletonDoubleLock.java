package com.design_pattern.singletion;

/**
 * Created by OY on 2019/11/8.
 */
/*
* 双重校验锁机制
* double-checked locking
* */
public class SingletonDoubleLock {

    private SingletonDoubleLock(){}

    //这里添加volatile主要作用是防止指令重排，内存可见次要原因
    private volatile static SingletonDoubleLock sdl;

    public static SingletonDoubleLock getSaveInstance(){
        if (sdl == null){
            //保证在第一次实例化时线程安全
            synchronized (SingletonDoubleLock.class){
                if (sdl == null){
                    sdl = new SingletonDoubleLock();
                }
            }
        }
        return sdl;
    }
}
