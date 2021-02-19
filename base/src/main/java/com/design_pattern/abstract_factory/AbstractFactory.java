package com.design_pattern.abstract_factory;

import com.design_pattern.abstract_factory.color.ColorFactory;
import com.design_pattern.factory.ShapeFactory;

/**
 * Created by OY on 2019/11/7.
 */
public abstract class AbstractFactory {

    abstract ShapeFactory getShapeFactory();
    abstract ColorFactory getColorFactory();
}
