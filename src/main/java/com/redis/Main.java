package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OY on 2019/3/31.
 */
@RestController
@EnableAutoConfiguration
public class Main {

    @RequestMapping("/")
    public String index(){
        return "hello world";
    }
    public static void main(String args[]){
        SpringApplication.run(Main.class, args);
    }
}
