package com.design_pattern.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by OY on 2019/11/11.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        InvocationHandler ih = new InvocationHandler();
        Method m = (Method) ih.proxy(Friend.class, "call");
        m.invoke(new Friend());
    }
}
