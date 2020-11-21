package com.java.java8inaction.chap3;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/21 16:59
 * @Description: Lambda表达式语法规则
 * (parameters) -> expression
 * （表达式-风格）
 * 或
 * (parameters) -> { statements; }
 * （块-风格）
 */
public class Lambda {

    public static void main(String[] args) {
        //根据上述语法规则，以下哪个不是有效的Lambda表达式？
        //1
//        () -> {};
        //2
//        () -> "Raoul";
        //3
//        () -> {return "hello";};
        //4
//        (Integer i) -> return "cc" + i;
        //5
//        (String s) -> {"cc";};

        //只有(4)和(5)是无效的Lambda，其余都是有效的。详细解释如下
        /*
        *4.return是一个控制流语句。要使此Lambda有效，需要使用花括号
        * 5.“Iron Man”是一个表达式，不是一个语句。要使此Lambda有效，可以去除花括号和分号
        * */
    }
}
