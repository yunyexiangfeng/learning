package com.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by OY on 2019/11/8.
 */
@Component
@Order(2)//改变接口执行顺序，这里改变ApplicationRunner和CommandLineRunner执行顺序，数值越小，优先级越高
//ApplicationRunner执行顺序默认比CommandLineRunner高
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("run org.springframework.boot.ApplicationRunner");
    }
}
