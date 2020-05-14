package com.algorithm.stack;

import java.util.Stack;

/**
 * Created by OY on 2020/4/21.
 */
public class MyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (outStack.size() > 0){
                inStack.push(outStack.pop());
            }
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {

            while (inStack.size() > 0){
                outStack.push(inStack.pop());
            }

            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {

            while (inStack.size() > 0){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {

            return outStack.empty();
        }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
