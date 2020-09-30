package com.design_pattern.proxy.javadynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy Class
 */
public class PrinterProxy implements InvocationHandler {
    private final static Logger LOG = LoggerFactory.getLogger(PrinterProxy.class);

    //被代理对象
    private IPrinter printer;

    public PrinterProxy(IPrinter printer) {
        Proxy.newProxyInstance(printer.getClass().getClassLoader(), printer.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOG.info("extra logic");
        method.invoke(printer, args);
        return null;
    }
}
