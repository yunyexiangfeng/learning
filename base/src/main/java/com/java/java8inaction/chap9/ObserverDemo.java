package com.java.java8inaction.chap9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/26 16:45
 * @Description: Lambda实现观察者模式
 */
public class ObserverDemo {
    public static void main(String[] args) {

        Subject feed = new Feed();
        //1.普通方式实现观察者模式
        //注册观察者
        feed.registerObserver(new NyTimes());
        feed.registerObserver(new GuarDian());
        feed.registerObserver(new LeMonde());

        //当Subject类状态发生变化时通知观察者
        feed.notifyObservers("The queen said her favourite book is Modern Java in Action!");

        System.out.println("-------------");
        feed.clearObservers();
        //2.Lambda方式实现观察者模式
        //此时Observer还是一个函数式接口；如果Observer接口变得复杂，就不能再使用lambda来实现观察者模式
        feed.registerObserver((String tweet) -> System.out.println("NY Times got news :" + tweet));
        feed.registerObserver((String tweet) -> System.out.println("GuarDian got news :" + tweet));
        feed.registerObserver((String tweet) -> System.out.println("LeMonde got news :" + tweet));
        //当Subject类状态发生变化时通知观察者
        feed.notifyObservers("The queen said her favourite book is Modern Java in Action!");
    }


    static interface Subject{
        void registerObserver(Observer observer);
        void notifyObservers(String tweet);
        void clearObservers();
    }
    //Subject实现类
    static final class Feed implements Subject{
        //持有观察者列表
        final List<Observer> observers = new ArrayList<>();
        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach((Observer o) -> o.notify(tweet));
        }

        @Override
        public void clearObservers(){
            observers.clear();
        }
    }


    @FunctionalInterface
    static interface Observer{
        void notify(String tweet);
    }
    //观察者实现类
    static final class NyTimes implements Observer{
        @Override
        public void notify(String tweet) {
            System.out.println("NY Times got news :" + tweet);
        }
    }
    static final class GuarDian implements Observer{
        @Override
        public void notify(String tweet) {
            System.out.println("GuarDian got news :" + tweet);
        }
    }
    static final class LeMonde implements Observer{
        @Override
        public void notify(String tweet) {
            System.out.println("LeMonde got news :" + tweet);
        }
    }
}
