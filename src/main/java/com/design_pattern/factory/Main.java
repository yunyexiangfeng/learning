package com.design_pattern.factory;

/**
 * Created by OY on 2019/11/7.
 */
public class Main {

    public static void main(String[] args) {
        //circle
        Shape circle = ShapeFactory.getShape(ShapeType.circle);
        circle.drawShape();
        //square
        Shape square = ShapeFactory.getShape(ShapeType.square);
        square.drawShape();
        //rectangle
        Shape rectangle = ShapeFactory.getShape(ShapeType.rectangle);
        rectangle.drawShape();
    }
}
