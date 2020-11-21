package com.java.java8inaction.chap2;


import com.java.java8inaction.entity.Apple;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 11:01
 * @Description: Java8 in action
 *  chap2
 *  2.2:行为参数化
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
