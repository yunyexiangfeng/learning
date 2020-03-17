package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
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
        Stream<String> stream = strings.stream().sorted().filter(c -> c.startsWith("ab"));
        stream.forEach(s -> {
            System.out.println(s);
        });
        Stream<String> parallelSteam = strings.parallelStream().sorted();
        parallelSteam.forEach(s -> {
            System.out.println(s);
        });
    }
}
