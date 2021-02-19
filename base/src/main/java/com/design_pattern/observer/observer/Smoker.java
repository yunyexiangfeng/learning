package com.design_pattern.observer.observer;

import com.design_pattern.observer.subject.Subject;

/**
 * concrete observer:smoker
 * Created by OY on 2019/11/11.
 */
public class Smoker implements Observer {


    @Override
    public void update(Subject subject) {
        System.out.println("stop smoking");
    }
}
