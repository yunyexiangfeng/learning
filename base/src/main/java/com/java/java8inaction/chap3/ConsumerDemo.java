package com.java.java8inaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/25 14:31
 * @Description: 测试Consumer函数式接口的accept方法
 *  其他方法的测试在后续章节中补充
 *
 *  Consumer接口：
 *      接受一个泛型对象T，并对T进行操作，无返回值(void)
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        foreach(Arrays.asList(1, 2, 4, 5, 3), (Integer i) -> System.out.println(i));
        foreach(Arrays.asList(1, 2, 4, 5, 3), System.out::println);
    }

    /**
     * 遍历集合
     * @param list 待遍历集合
     * @param consumer
     * @param <T>
     */
    private static <T> void foreach(List<T> list, Consumer<T> consumer){
        for (T t : list){
            consumer.accept(t);
        }
    }
}
