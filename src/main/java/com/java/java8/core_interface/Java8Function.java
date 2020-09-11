package com.java.java8.core_interface;

import org.junit.Test;

import java.util.function.Function;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java.java8.core_interface
 * @ClassName: Java8Function
 * @Description: test java8 function interface
 * @Author: Administrator
 * @CreateDate: 2020/4/1 11:31
 */
public class Java8Function {

    @Test
    public void test(){

        Function<String, String> funOne = x -> x + "test";
        String jihu = funOne.apply("jihu");
        System.out.println(jihu);
    }
}
