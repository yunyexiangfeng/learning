package com.java.java8inaction.chap3.functioninterface;

/**
 * 非函数式接口
 *    超过一个函数式接口（内部实现 + 继承）
 *   使用@FunctionalInterface进行标注时会编译错误
 */
//@FunctionalInterface
public interface SmartAddr extends Addr {
    int add(double a, double b);
}
