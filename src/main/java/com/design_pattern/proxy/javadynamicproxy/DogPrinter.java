package com.design_pattern.proxy.javadynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.design_pattern.proxy.javadynamicproxy
 * @ClassName: DogPrinter
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/9/30 16:52
 */
public class DogPrinter implements IPrinter {
    private final static Logger LOG = LoggerFactory.getLogger(DogPrinter.class);
    @Override
    public void print() {
        LOG.info("I am a dog.");
    }
}
