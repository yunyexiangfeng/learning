package com.design_pattern.strategy;

import org.junit.Test;

public class StrategyTest {
    @Test
    public void test(){
        StrategyContext contextOne = new StrategyContext(new StrategyOne());
        contextOne.contextMethod();
        StrategyContext contextTwo = new StrategyContext(new StrategyTwo());
        contextTwo.contextMethod();
    }
}
