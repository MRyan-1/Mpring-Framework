package org.mryan.factory;

import org.mryan.PropertyValues;

/**
 * @description： 用于定义Bean实例化定义信息
 * @Author MRyan
 * @Date 2021/9/11 21:33
 * @Version 1.0
 */
public class BeanDefinition {

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;

    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
