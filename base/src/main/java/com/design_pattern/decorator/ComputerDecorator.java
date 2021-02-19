package com.design_pattern.decorator;

/**
 * 装饰者组件的具体实现
 * 使用电脑对程序员进行包装
 * Created by OY on 2020/3/21.
 */
public class ComputerDecorator extends HumanDecorator {
    public ComputerDecorator(Human h) {
        super(h);
    }

    @Override
    public void work() {
        human.work();
        System.out.print(" work with computer");
    }
}
