package com.design_pattern.proxy;

import com.design_pattern.proxy.dynamic.Friend;
import com.design_pattern.proxy.dynamic.InvocationHandler;
import com.design_pattern.proxy.static_p.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by OY on 2019/11/11.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //dynamic proxy
        InvocationHandler ih = new InvocationHandler();
        Method m = (Method) ih.proxy(Friend.class, "call");
        m.invoke(new Friend());

        Method mp = (Method) ih.proxy(Friend.class, "call", String.class);
        mp.invoke(new Friend(), "for args");

        //static proxy
        Proxy proxy = new Proxy();
        proxy.show();
    }
}
