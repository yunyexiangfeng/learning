package com.design_pattern.abstract_factory;

import com.design_pattern.abstract_factory.color.ColorFactory;
import com.design_pattern.factory.ShapeFactory;

/**
 * Created by OY on 2019/11/7.
 */
public class FactoryProducer extends AbstractFactory {
    @Override
    ShapeFactory getShapeFactory() {
        return new ShapeFactory();
    }

    @Override
    ColorFactory getColorFactory() {
        return new ColorFactory();
    }
}
