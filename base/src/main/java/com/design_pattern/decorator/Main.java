package com.design_pattern.decorator;

/**
 * Created by OY on 2020/3/21.
 */
public class Main {
    public static void main(String args[]){
        Human doctor = new Doctor();
        Human dnd = new KnifeDecorator(doctor);
        dnd.work();

        Human programmer = new Programmer();
        Human pcd = new ComputerDecorator(programmer);
        pcd.work();


    }
}
