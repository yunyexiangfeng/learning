package com.web.Service.Impl;

import com.activeMq.ConsumerDemo;
import com.activeMq.ProducerDemo;
import com.web.Service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.Service.Impl
 * @ClassName: HelloWorldServiceImpl
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/1/19 17:34
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Resource
    private ConsumerDemo consumerDemo;

    @Autowired
    private ProducerDemo producer;

    @Override
    public String getMessage() {
        String message = consumerDemo.consumeMessage();
        if (message == null){
            return "There is no message";
        }
        return message;
    }

    @Override
    public void createMessage() {
        producer.productMessage();
    }
}
