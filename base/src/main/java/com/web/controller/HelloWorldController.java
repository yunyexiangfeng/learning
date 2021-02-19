package com.web.controller;

import com.java.compareTo.Person;
import com.web.Service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.controller
 * @ClassName: HelloWorldController
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/12/13 18:28
 */
@Controller
@ResponseBody
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Resource
    HelloWorldService helloWorldService;

    @GetMapping(value = "/hello")
    public String sayHello(){
        logger.error("hello world");
        logger.warn("hello world");
        logger.info("hello world");
        logger.debug("hello world");
        logger.trace("hello world");
        return "Hello world";
    }

    @GetMapping(value = "/getPerson")
    public Person  getPerson(){
        return new Person();
    }


    @GetMapping(value = "/getMessage")
    public String getMessage(){
        return helloWorldService.getMessage();
    }

    @GetMapping(value = "/createMessage")
    public void createMessage(){
        helloWorldService.createMessage();
    }
}
