package com.design_pattern.observer.subject;

/**
 * concrete subject one
 * Created by OY on 2020/3/24.
 */
public class ConcreteSubjectOne extends Subject {

    private String state;

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
        //notify observers when state changed
        this.notifyObserver();
    }
}
