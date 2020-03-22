package com.design_pattern.decorator;

/**
 * 装饰者组件
 * 持有Human引用，便于子类进行包装
 * 同时保证只对Human进行包装，单一职责
 * Created by OY on 2020/3/21.
 */
public abstract class HumanDecorator implements Human{

    protected Human human;
    public HumanDecorator(Human h) {
        this.human = h;
    }

}
