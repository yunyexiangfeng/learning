package com.design_pattern.observer.subject;

import com.design_pattern.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OY on 2019/11/11.
 */
public class Subject {

    //concrete observer list
    public List<Observer> observers = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void notifyObserver(){
        //on observer side, there are two modes
        //1.pull mode: parameter is subject
        observers.forEach(item -> item.update(this));

        //2.push mode:parameter are attributes of subject
//        observers.forEach(item -> item.update(this.getState()));

    }

    /*
    * add observer into list
    * */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /*
    * delete observer from list
    * */
    public void detach(Observer observer){
        observers.remove(observer);
    }
}
