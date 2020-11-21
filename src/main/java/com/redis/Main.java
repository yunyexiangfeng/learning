package com.redis;

import com.web.Entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by OY on 2019/3/31.
 */
public class Main {

    public static void main(String args[]){
        int size = 1000;
        int start = 0;
        int n = 0;
        while (n < 5){
            n ++;
            start += size;
        }
        System.out.println(start);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //test stream
        strings.forEach(s -> {
            s = s.toUpperCase();
        });
        strings.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("---------------------------------------");
        //test parallelStream
        Stream<String> parallelSteam = strings.parallelStream().sorted();
        parallelSteam.forEach(System.out::println);

        //test Collectors(Collectors is for stream)
        System.out.println(strings.stream().collect(Collectors.joining(",")));
        System.out.println(strings.stream().distinct().collect(Collectors.joining(",")));


        //test list foreach
        List<String> strings1 = Arrays.asList("aa,bb".split(","));
        strings1.forEach(s -> System.out.println(s));

        System.out.println("-----------------------------");


    }

}
