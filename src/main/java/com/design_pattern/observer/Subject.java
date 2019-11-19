package com.design_pattern.observer;

/**
 * Created by OY on 2019/11/11.
 */
public class Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void notifyObserver(Observer observer){
        observer.update();
    }
}
