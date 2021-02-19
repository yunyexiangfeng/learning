package com.design_pattern.decorator;

/**
 * Created by OY on 2020/3/21.
 */
public class Doctor implements Human {
    @Override
    public void work() {
        System.out.print("I am a doctor.");
    }

}
