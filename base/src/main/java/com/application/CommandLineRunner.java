package com.application;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by OY on 2019/11/8.
 */
@Component
@Order(1)//改变接口执行顺序，这里改变ApplicationRunner和CommandLineRunner执行顺序，数值越小，优先级越高
//ApplicationRunner执行顺序默认比CommandLineRunner高
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("run org.springframework.boot.CommandLineRunner");
    }
}
