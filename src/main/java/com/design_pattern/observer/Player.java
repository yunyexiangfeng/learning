package com.design_pattern.observer;

/**
 * Created by OY on 2019/11/11.
 */
public class Player implements Observer {
    @Override
    public void update() {
        System.out.println("stop playing");
    }
}
