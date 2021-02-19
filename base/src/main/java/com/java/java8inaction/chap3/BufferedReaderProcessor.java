package com.java.java8inaction.chap3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
