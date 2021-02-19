package com.java.java8inaction.chap2.javaapi;

import com.java.java8inaction.entity.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 16:33
 * @Description: Lambda替换Java API中的匿名表达式接口
 *  //java.util.Comparator
 *  public interface Comparator<T> {
 *      int compare(T o1, T o2);
 *  }
 *
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        //使用Comparator排序
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return (o1.getWeight() < o2.getWeight()) ? -1 : ((o1.getWeight() == o2.getWeight()) ? 0 : 1);
            }
        });

        //使用lambda排序
        inventory.sort((o1, o2) -> (o1.getWeight() < o2.getWeight()) ? -1 : ((o1.getWeight() == o2.getWeight()) ? 0 : 1));
    }
}
