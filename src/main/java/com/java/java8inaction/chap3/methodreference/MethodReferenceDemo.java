package com.java.java8inaction.chap3.methodreference;

import com.java.java8inaction.entity.Apple;
import com.java.java8inaction.entity.Color;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/25 17:29
 * @Description:
 *
 * 1. 指向静态方法的方法引用
 * 2. 指向任意类型实例方法的方法引用
 * 3. 指向现存对象或表达式实例方法的方法引用
 */
public class MethodReferenceDemo {

    @Test
    public void methodReference(){

        //1.指向静态方法的方法引用
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("hello lambda");
        consumer = System.out::println;
        consumer.accept("hello method reference: static method");

        //2.指向任意类型实例方法的方法引用
        consumer = (String s) -> s.length();
        consumer.accept("hello lambda");
        consumer = String::length;
        consumer.accept("hello method reference: instance method");

        //3.指向现存对象或表达式实例方法的方法引用
    }

    @Test
    public void constructorReference(){

        //1.无参构造函数
        Supplier<Apple> supplier = Apple::new;
        Apple apple = supplier.get();
        System.out.println(apple.toString());
        //等价于
        supplier = () -> new Apple();
        apple = supplier.get();
        System.out.println(apple.toString());

        //2.含2个参数构造函数
        Function<String, Apple> function = Apple::new;
        apple = function.apply(Color.RED.name());
        System.out.println(apple.toString());
        //等价于
        function = (color) -> new Apple(color);
        apple = function.apply(Color.YELLOW.name());
        System.out.println(apple.toString());

        //3.含3个参数构造函数
        BiFunction<String, Integer, Apple> biFunction = Apple::new;
        apple = biFunction.apply(Color.RED.name(), 150);
        System.out.println(apple.toString());
        //等价于
        biFunction = (color, i) -> new Apple(color, i);
        apple = biFunction.apply(Color.RED.name(), 200);
        System.out.println(apple.toString());


        //example
        Map<String, Function<String, Apple>> map = new HashMap<>();
        map.put("redApple", Apple::new);
        map.put("greenApple", Apple::new);

        apple = map.get("redApple").apply(Color.RED.name());
        System.out.println(apple.toString());
        apple = map.get("redApple").apply(Color.YELLOW.name());
        System.out.println(apple.toString());

    }

}
