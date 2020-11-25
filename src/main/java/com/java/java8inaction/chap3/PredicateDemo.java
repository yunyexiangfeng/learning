package com.java.java8inaction.chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 测试Predicate函数式接口的test方法
 *  其他方法在以后的章节中补充
 * Predicate接口：
 *      接受一个泛型对象T，并对T进行操作，获取一个boolean返回值
 */
public class PredicateDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("");
        list.add("c");
        Predicate<String> nonEmptyPredicate = (String s) -> !s.isEmpty();
//        Predicate<String> nonEmptyPredicate = String::isEmpty;
        List<String> result = filter(list, nonEmptyPredicate);
        for (String s : result){
            System.out.println(s);
        }

    }

    /**
     * 根据predicate的行为进行过滤
     * @param list 待过滤集合
     * @param predicate 过滤行为
     * @param <T>
     * @return 过滤后的结果集
     */
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : list){
            if (predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
