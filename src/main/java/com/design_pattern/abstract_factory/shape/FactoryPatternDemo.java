package com.design_pattern.abstract_factory.shape;

/**
 * Created by OY on 2019/11/7.
 */
public class FactoryPatternDemo {

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
