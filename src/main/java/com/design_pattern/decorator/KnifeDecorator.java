package com.design_pattern.decorator;

/**
 * 装饰者组件的具体实现
 * 使用手术刀对医生进行包装
 * Created by OY on 2020/3/21.
 */
public class KnifeDecorator extends HumanDecorator {
    public KnifeDecorator(Human h) {
        super(h);
    }

    @Override
    public void work() {
        human.work();
        System.out.println("work with knife");
    }
}
