package com.design_pattern.proxy.javadynamicproxy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Proxy;

/**
 * @Author: Administrator
 * @CreateDate: 2020/9/30 16:56
 */
public class TestCase {

    private final static Logger LOG = LoggerFactory.getLogger(TestCase.class);
    @Test
    public void test(){
        IPrinter dogPrinter = (IPrinter) PrinterProxy.getProxy(new DogPrinter());
        dogPrinter.print();
        try {
            IPrinter machinePrinter = (IPrinter) PrinterProxy.getProxy(new MachinePrinter());
            machinePrinter.print();
        }catch (Exception e){
            LOG.info("aop throw exception");
        }

        File file = new File("F:\\ww\\test.txt");
        System.out.println(file.delete());
        System.out.println(file.getParentFile().delete());
    }
}
