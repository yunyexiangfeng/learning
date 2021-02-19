package com.java.java8inaction.chap3;

import java.io.*;
import java.util.function.Function;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/25 12:12
 * @Description: 使用lambda + functionalInterface实现参数化行为的案例
 * 在实际应用场景中，除了可以自定义函数式接口，还可以复用以下API：
 * 1.Consumer及子接口
 * 2.Predicate及子接口
 * 3.Function及子接口
 * 4.Supplier及子接口
 * 5.Operator及子接口
 *
 * 6.Runnable
 * 7.Callable
 * 8.Comparator
 */
public class LambdaDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new FileReader("F:\\workspace\\lambdaDemo.txt");
        //1.使用processFile()方法读取行
        try {
            System.out.println(processFile(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.使用processFile(BufferedReaderProcessor brp)方法读取行
        //BufferedReaderProcessor自定义函数并抛出异常, java api提供的函数式接口一般不抛异常
        try {
            System.out.println(processFile((BufferedReaderProcessor) (br) -> br.readLine(), reader));
            //processFile没有重载的情况下（即不会有多个函数式接口作为参数），可以不使用BufferedReaderProcessor(br)进行强制转换
//            System.out.println(processFile((br) -> br.readLine()));
            //使用方法引用进行调用
//            System.out.println(processFile(BufferedReader::readLine));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //当需求发生变更，需要读取两行，可以直接复用processFile(BufferedReaderProcessor brp)方法
        try {
            System.out.println(processFile((BufferedReaderProcessor) br -> br.readLine() + " and " + br.readLine(), reader));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.显示捕捉异常
        Function<BufferedReader, String> function = (br) -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };
        System.out.println(processFile(function, reader));

    }

    /**
     * Read a line from a file
     *
     * 1.使用传统方式处理
     * 缺点：一次性行为，不利于扩展。扩展时需进行重载
     * @return
     */
    private static String processFile(Reader reader) throws IOException {
        try(BufferedReader br = new BufferedReader(reader)) {
            return br.readLine();
        }
    }

    /**
     * Read lines from a file
     *
     * 2.使用lambda和自定义函数式接口进行行为参数化处理
     * 优点：行为参数化，一个方法可以处理更多场景
     * @param brp
     * @return
     * @throws IOException
     */
    private static String processFile(BufferedReaderProcessor brp, Reader reader) throws IOException {
        try(BufferedReader br = new BufferedReader(reader)) {
            return brp.process(br);
        }
    }

    /**
     *Read lines from a file
     *
     * 3.使用lambda和JAVA API提供的函数式接口实现行为参数化处理
     * @param function 转换函数
     * @return
     */
    private static String processFile(Function<BufferedReader, String> function, Reader reader){
        try(BufferedReader br = new BufferedReader(reader)) {
            return function.apply(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
