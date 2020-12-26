package com.java.java8inaction.chap9;

import java.util.function.Supplier;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/27 17:13
 * @Description: default
 */
public class FactoryDemo {
    public static void main(String[] args) {
        //old school
        Product productOld = ProductFactory.createProduct("loan");

        //lambda
        Supplier<Product> loanSupplier = Loan::new;
        Supplier<Product> stockSupplier = Stock::new;
        Supplier<Product> bondSupplier = Bond::new;
        Loan loan = (Loan) loanSupplier.get();
    }

    private static final class ProductFactory{
        public static Product createProduct(String name){
            if (name == null){
                return null;
            }
            switch(name){
                case "loan" : return new Loan();
                case "stock" : return new Stock();
                case "bond" : return new Bond();
                default: return null;
            }
        }
    }

    private static class Product{
        String name;
    }
    private static final class Loan extends Product{}
    private static final class Stock extends Product{}
    private static final class Bond extends Product{}
}
