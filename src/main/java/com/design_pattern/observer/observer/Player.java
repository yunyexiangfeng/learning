package com.design_pattern.observer.observer;

import com.design_pattern.observer.subject.Subject;

/**
 * concrete observer:player
 * Created by OY on 2019/11/11.
 */
public class Player implements Observer {
    @Override
    public void update(Subject subject) {
        System.out.println("stop playing");
    }
}
