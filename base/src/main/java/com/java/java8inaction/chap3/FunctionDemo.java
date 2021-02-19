package com.java.java8inaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/25 14:52
 * @Description: 测试Function接口的apply方法
 *  其他方法的测试在后续章节补充
 *
 *  Function接口：
 *      接受一个泛型对象T，并对T进行操作，返回操作后的一个结果泛型对象R
 */
public class FunctionDemo {

    public static void main(String[] args) {
        //输入值为字符串集合，输出为整型集合
        List<Integer> result = map(Arrays.asList("lambda", "cc", "test"), (String s) -> s.length());
//        map(Arrays.asList("lambda", "cc", "test"), String::length);
        for (Integer i : result){
            System.out.println(i);
        }
    }


    /**
     * 映射方法，将<T>集合映射为<R>集合
     * @param list 待转换集合
     * @param function 转换方法
     * @param <T> 入参类型
     * @param <R> 出参类型
     * @return 转换后集合
     */
    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T t : list){
            R r = function.apply(t);
            result.add(r);
        }
        return result;
    }
}

