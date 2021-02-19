package com.design_pattern.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * Created by OY on 2019/11/11.
 */
public class InvocationHandler {
    /*
    * 代理方法
    * cls   被代理类
    * method    被代理方法
    * */
    public Object proxy(Class cls, String method){
        Method m = null;
        try {
             m = cls.getMethod(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }
    /*
    * 代理方法
    * cls   被代理类
    * method    被代理方法
    * args  被代理方法参数类型列表
    * */
    public Object proxy(Class cls, String method, Class... parameters){
        Method m = null;
        try {
            m = cls.getMethod(method, parameters);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return m;
    }
}
