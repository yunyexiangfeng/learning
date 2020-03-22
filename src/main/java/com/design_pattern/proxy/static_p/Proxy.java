package com.design_pattern.proxy.static_p;

/**
 * Created by OY on 2020/3/22.
 */
public class Proxy {
    //持有被代理对象引用
    private Frame frame;
    public void show(){
        frame = new Frame();
        frame.show();
    }
}
