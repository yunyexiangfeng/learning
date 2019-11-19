package com.design_pattern.abstract_factory.shape;

/**
 * Created by OY on 2019/11/7.
 */
public class ShapeFactory {
    Shape getShape(){
        return null;
    }
    static Shape getShape(ShapeType type){
        if (type == null){
            return null;
        }
        switch (type){
            case circle:
                return new Circle();
            case square:
                return new Square();
            case rectangle:
                return new Rectangle();
            default:
                return null;
        }
    }
}
