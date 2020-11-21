package com.java.java8inaction.chap2;

import com.java.java8inaction.entity.Apple;
import com.java.java8inaction.entity.Color;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 11:07
 * @Description: default
 */
public class AppleColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.name().equals(apple.getColor());
    }
}
