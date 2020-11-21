package com.design_pattern.proxy.javadynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy Class
 *
 * java动态代理：
 * 1.java.lang.reflect.Proxy
 *  生成代理对象
 * 2.java.lang.reflect.InvocationHandler
 *  调用被代理的方法
 */
public class PrinterProxy {
    private final static Logger LOG = LoggerFactory.getLogger(PrinterProxy.class);

    public static Object getProxy(final Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //logic before proxy method executed
                LOG.info("aop before : 开始执行代理方法: {}()", method.getName());
                method.invoke(object, args);
                //logic after proxy method executed
                LOG.info("aop after : 执行完毕");
                return null;
            }
        });
    }
}
