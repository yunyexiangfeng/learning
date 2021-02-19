package com.design_pattern.proxy.dynamic;

/**
 * Created by OY on 2019/11/11.
 */
public class Friend {
    public void call(){
        System.out.println("I have been called");
    }

    public void call(String arg){
        System.out.println("I have been called : " + arg);
    }

}
