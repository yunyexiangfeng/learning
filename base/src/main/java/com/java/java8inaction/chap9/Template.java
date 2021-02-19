package com.java.java8inaction.chap9;

import java.util.function.Consumer;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/26 15:37
 * @Description: Lambda实现模板模式
 */
public class Template {
    public static void main(String[] args) {
        //1.普通方式实现模板模式
        OnlineBanking ob = new CaoxiRoadOnlineBanking();
        ob.processCustomer(1);

        ob = new BeijingRoadOnlineBanking();
        ob.processCustomer(1);

        //2.使用lambda表达式方式实现模板模式

        OnlineBankingL obl = new OnlineBankingL();
        obl.processCustomer(1, (Customer customer) -> System.out.println("Caoxi Road Bank make " + customer +" happy"));
        obl.processCustomer(1, (Customer customer) -> System.out.println("Beijing Road Bank make " + customer +" happy"));
    }
    //Lambda表达式方式实现模板模式
    static class OnlineBankingL{
        public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
            Customer customer = new Customer(id);
            makeCustomerHappy.accept(customer);
        }
    }

    //普通模式实现模板模式，这种方式需要配合抽象方法及实现抽象方法的子类
    abstract static class OnlineBanking{
        public void processCustomer(int id){
            Customer customer = new Customer(id);
            makeCustomerHappy(customer);
        }
        abstract void makeCustomerHappy(Customer customer);
    }
    //不同支行实现不同的makeCustomerHappy方法
    private static final class CaoxiRoadOnlineBanking extends OnlineBanking{
        @Override
        void makeCustomerHappy(Customer customer) {
            System.out.println("Caoxi Road Bank make " + customer +" happy");
        }
    }
    private static final class BeijingRoadOnlineBanking extends OnlineBanking{
        @Override
        void makeCustomerHappy(Customer customer) {
            System.out.println("Beijing Road Bank make " + customer +" happy");
        }
    }

    private static final class Customer{
        private int id;

        public Customer(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
