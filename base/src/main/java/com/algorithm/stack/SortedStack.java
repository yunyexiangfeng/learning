package com.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 * 面试题 03.05. 栈排序
 *
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 */
public class SortedStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * 初始化stack
     */
    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 将值压入栈时进行排序
     * @param val value
     */
    public void push(int val) {
        if (this.isEmpty()){
            stack1.push(val);
            return;
        }
        while (!stack1.isEmpty() && stack1.peek() < val){
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (this.isEmpty())
            return;
        stack1.pop();
    }

    public int peek() {
        if (this.isEmpty())
            return -1;
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack ss = new SortedStack();
        ss.push(1);
        ss.push(2);
        ss.push(4);
        ss.push(7);
        ss.push(5);
        while (!ss.isEmpty()){
            System.out.println(ss.peek());
            ss.pop();
        }
    }
}
