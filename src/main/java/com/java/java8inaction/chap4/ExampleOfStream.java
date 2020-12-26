package com.java.java8inaction.chap4;

import com.java.java8inaction.entity.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/26 10:29
 * @Description: default
 */
public class ExampleOfStream {
    public static void main(String[] args) {
        //定义菜单
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", false, 120, Dish.Type.OTHER),
                new Dish("pizza", false, 800, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.OTHER)
        );

        //1.Java7 实现Dish按calories筛选、排序
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu){
            //筛选卡路里小于400的Dish
            if (dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }
        //对卡路里小于400的Dish排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        //处理排序后的Dish name列表
        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish dish : lowCaloricDishes){
            lowCaloricDishNames.add(dish.getName());
        }
        //输出Dish name列表
        System.out.println("Java7处理后输出:");
        for (String name : lowCaloricDishNames){
            System.out.println(name);
        }

        //2.Java8 实现Dish按calories筛选、排序
        lowCaloricDishNames = menu.stream()
                .filter((Dish dish) -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        //输出Dish name列表
        System.out.println("Java8处理后输出:");
        for (String name : lowCaloricDishNames){
            System.out.println(name);
        }
    }
}
