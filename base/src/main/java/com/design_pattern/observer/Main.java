package com.design_pattern.observer;

import com.design_pattern.observer.observer.Observer;
import com.design_pattern.observer.observer.Player;
import com.design_pattern.observer.observer.Sleeper;
import com.design_pattern.observer.observer.Smoker;
import com.design_pattern.observer.subject.ConcreteSubjectOne;
import com.design_pattern.observer.subject.Subject;

/**
 * Created by OY on 2019/11/11.
 */
public class Main {
    public static void main(String[] args) {

        Subject subject = new ConcreteSubjectOne();
        subject.setState("update");

        //register observers
        Observer player = new Player();
        Observer sleeper = new Sleeper();
        Observer smoker = new Smoker();
        subject.attach(player);
        subject.attach(sleeper);
        subject.attach(smoker);

        //notify observers when concrete subject's state changed
        subject.setState("haha");
    }
}
