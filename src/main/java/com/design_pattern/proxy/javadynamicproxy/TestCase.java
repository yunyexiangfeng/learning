package com.design_pattern.proxy.javadynamicproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.design_pattern.proxy.javadynamicproxy
 * @ClassName: Test
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/9/30 16:56
 */
public class TestCase {

    @Test
    public void test(){
        Class<?>[] classes = IPrinter.class.isInterface() ? IPrinter.class.getInterfaces() : new Class[]{IPrinter.class.getClass()};
        IPrinter printer = (IPrinter) Proxy.newProxyInstance(TestCase.class.getClassLoader(), classes, new PrinterProxy());
        printer.print();
    }
}
