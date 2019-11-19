package com.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by OY on 2019/3/31.
 */
public class Example {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

}
