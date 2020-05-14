package com.algorithm.stack;

import java.util.Stack;

/**
 * 栈的最小值
 * https://leetcode-cn.com/problems/min-stack-lcci/
 *
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * Created by OY on 2020/4/26.
 */
public class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        mins = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        //x为int类型，在比较时可以不使用包装类
        //mins.peek()会自动拆箱
        if (mins.empty() || mins.peek() >= x){
            mins.push(x);
        }
    }

    public void pop() {
        //最小值移出的时候，min下移
        //stack的范型使用int包装类型，必须使用equals
        if(stack.pop().equals(mins.peek())){
            mins.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
