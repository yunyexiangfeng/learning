package com.java;

import com.java.compareTo.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java
 * @ClassName: Main
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/12/7 13:03
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(14);
        list.add(2);
        System.out.println(list.size());
        list.forEach(i -> {
            System.out.println(i);
        });
    }

    public static Integer getInt(){
        return null;
    }

    public static void personCompare(List<Person> persons){

    }
}