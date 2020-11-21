package com.java.java8inaction.chap2;

import com.java.java8inaction.entity.Apple;
import com.java.java8inaction.entity.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 11:40
 * @Description: default
 */
public class FilterApples {


    public static void main(String[] args) {
        Apple redApple = new Apple(Color.RED.name(), 100);
        Apple greenApple = new Apple(Color.GREEN.name(), 200);
        Apple yellowApple = new Apple(Color.YELLOW.name(), 300);
        List<Apple> apples = new ArrayList<>();
        apples.add(redApple);
        apples.add(greenApple);
        apples.add(yellowApple);
        //1.多种行为，一个参数
        System.out.println("---------实现行为接口(ApplePredicate)---------");
        List<Apple> result1 = filterApples(apples, new AppleColorPredicate());
        List<Apple> result2 = filterApples(apples, new AppleWeightPredicate());
        print(result1);
        print(result2);

        //2.匿名内部类。能减少ApplePredicate实现类，依然繁琐
        System.out.println("---------匿名内部类---------");
        List<Apple> result3 = filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() < 150;
            }
        });
        print(result3);

        //3.使用lambda表达式。
        System.out.println("---------Lambda---------");
        List<Apple> result4 = filterApples(apples,(apple) -> Color.YELLOW.toString().equals(apple.getColor()));
        print(result4);
    }

    /**
     * 1.Filter apples by Strategy Pattern
     * 缺点：
     * 需要声明很多实现ApplePredicate接口的类
     * 需要实例化好几个只会提到一次的ApplePredicate对象
     * @param apples apple list before filter
     * @param predicate strategy for filter -> 参数化行为
     * @return apple list after filter
     */
    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples){
            if (predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }



    /**
     * Print apple's information
     * @param apples
     */
    private static void print(List<Apple> apples){
        Consumer<Apple> consumer = (apple) ->{
            System.out.println(apple.toString());
        };
        apples.forEach(consumer);
    }


}
