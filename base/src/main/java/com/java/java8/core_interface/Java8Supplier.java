package com.java.java8.core_interface;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java.java8.core_interface
 * @ClassName: Java8Supplier
 * @Description: 供给接口：测试Supplier接口
 *
 * @Author: Administrator
 * @CreateDate: 2020/1/5 15:36
 */
public class Java8Supplier {

    @Test
    public void testSupplier(){
        //1. 使用Supplier接口实现方法,只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());


        //2. 使用lambda表达式，
        supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());

        //3. 使用方法引用
        Supplier<Double> doubleSupplier = Math::random;
        System.out.println(doubleSupplier.get());
    }
}
