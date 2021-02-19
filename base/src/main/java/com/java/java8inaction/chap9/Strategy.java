package com.java.java8inaction.chap9;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/26 15:08
 * @Description: Lambda实现策略模式
 */
public class Strategy {

    public static void main(String[] args) {
        //1.普通策略模式实现
        //除了策略模式接口，还需要大量实现类去实现各种具体策略。
        Validator numericValidator = new Validator(new IsNumeric());
        System.out.println(numericValidator.validate("aaa"));

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println(lowerCaseValidator.validate("bbb"));

        System.out.println("--------");
        //2.使用lambda方式实现策略模式
        //使用lambda表达式替代各种具体实现类
        numericValidator = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(numericValidator.validate("aaa"));

        lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(lowerCaseValidator.validate("bbb"));

    }
    private static final class Validator{
        private final ValidationStrategy strategy;
        public Validator(ValidationStrategy strategy){
            this.strategy = strategy;
        }
        public boolean validate(String s){
            return strategy.execute(s);
        }
    }

    public static interface ValidationStrategy {
        boolean execute(String s);
    }

    //各种策略的具体实现类
    public static final class IsAllLowerCase implements ValidationStrategy{
        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }
    public static final class IsNumeric implements ValidationStrategy{
        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }
}
