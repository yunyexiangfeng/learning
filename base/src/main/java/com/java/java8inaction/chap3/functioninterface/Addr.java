package com.java.java8inaction.chap3.functioninterface;

/**
 * 函数式接口
 *  只有一个抽象方法
 *  可以使用@FunctionalInterface进行标注
 */
//@FunctionalInterface
public interface Addr {
    int add(int a, int b);
}
