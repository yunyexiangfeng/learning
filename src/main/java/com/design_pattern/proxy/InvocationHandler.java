package com.design_pattern.proxy;

import java.lang.reflect.Method;

/**
 * Created by OY on 2019/11/11.
 */
public class InvocationHandler {

    public Object proxy(Class cls, String method){
        Method m = null;
        try {
             m = cls.getMethod(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }

}
