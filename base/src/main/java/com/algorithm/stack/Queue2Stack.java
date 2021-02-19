package com.algorithm.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by OY on 2020/4/24.
 */
public class Queue2Stack {
    //主队列
    Queue<Integer> queue1;
    //辅助队列
    Queue<Integer> queue2;

    //使用辅助空间记录栈顶元素
    //也就是最后一个入对值
    int top;

    @Test
    public void test(){

    }

    /** Initialize your data structure here. */
    public Queue2Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack.
     * 时间复杂度：O(1)
     * */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element.
     * 一次循环
     * 时间复杂度：O(n)
     * */
    public int pop() {
        int last = 0;
        //将主队列放入辅助队列，并返回最后一个值
        if (!queue1.isEmpty()){
            while (queue1.size() > 1){
                //当栈顶元素弹出后，第二个元素作为top返回
                top = queue1.poll();
                queue2.add(queue1.poll());
            }
            last = queue1.poll();
            //将辅助队列还原到主队列
            //此处可以直接使用引用交换，可避免多一次循环：
            Queue<Integer> tempQ = queue1;
            queue1 = queue2;
            queue2 = tempQ;
            /*while (queue2.size() > 0){
                queue1.add(queue2.poll());
            }*/
        }
        return last;
    }

    /** Get the top element.
     * 时间复杂度：O(1)
     * */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1 == null || queue1.size() == 0){
            return true;
        }
        return false;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
