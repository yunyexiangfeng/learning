package com.java.java8.core_interface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java.java8.core_interface
 * @ClassName: Java8Consumer
 * @Description: 消费接口：测试Consumer接口
 *                  1.lambda表达式的返回值是Consumer，所以forEach等函数可以直接使用lambda作为参数传入。
 *                  2.方法引用可以作为一个Consumer
 *                  3.其他Consumer接口：IntConsumer、DoubleConsumer、LongConsumer、BiConsumer
 * @Author: Administrator
 * @CreateDate: 2020/1/5 15:07
 */
public class Java8Consumer {
    @Test
    public void testConsumerInterface(){
        //1.实现accept方法
        //定义consumer
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        //定义流
        Stream stream = Stream.of("abc", "", "bc", "efg", "abcd","", "jkl");
        //使用consumer
        stream.forEach(consumer);

        //2.lambda表达式返回
        //使用lambda返回consumer
        consumer =  (s) -> System.out.println(s);
        stream = Stream.of("abc", "bc", "efg", "abcd","jkl");
        stream.forEach(consumer);

        //3.方法引用
        //使用方法引用返回consumer
        consumer = System.out::println;
    }
}
