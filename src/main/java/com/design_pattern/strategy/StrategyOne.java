package com.design_pattern.strategy;

/**
 *Strategy one implement from IStrategy interface
 * @Author
 */
public class StrategyOne implements IStrategy{
    @Override
    public void algorithmMethod() {
        System.out.println("strategy one been called");
    }
}
