package com.java.java8inaction.chap2;

import com.java.java8inaction.entity.Apple;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 11:07
 * @Description: default
 */
public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
