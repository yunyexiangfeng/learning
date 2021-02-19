package com.design_pattern.strategy;

/**
 * 策略上下文，持有策略
 * @Author oct
 */
public class StrategyContext {

    private IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void contextMethod(){
        this.strategy.algorithmMethod();
    }
}
