package com.java.java8inaction.chap9;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/27 12:10
 * @Description: Lambda实现责任链模式
 */
public class ResponsibilityChainDemo {
    public static void main(String[] args) {
        //1.普通方式实现责任链模式
        ProcessingObject<String> handleText = new HeaderTextProcessing();
        ProcessingObject<String> spellChecker = new SpellCheckerProcessing();


        //2.Lambda方式实现责任链模式

    }

    private static abstract class ProcessingObject<T extends Object>{
        protected ProcessingObject<T> successors;
        public void setSuccessors(ProcessingObject<T> successors){
            this.successors = successors;
        }

        public T handle(T input){
            //处理input
            T t = handleWork(input);
            if (successors != null){
                //交给下一层继续处理input
                successors.handleWork(input);
            }
            return t;
        }

        abstract protected T handleWork(T input);
    }

    private static final class HeaderTextProcessing extends ProcessingObject<String>{
        @Override
        protected String handleWork(String input) {
            return null;
        }
    }
    private static final class SpellCheckerProcessing extends ProcessingObject<String>{
        @Override
        protected String handleWork(String input) {
            return null;
        }
    }
}
