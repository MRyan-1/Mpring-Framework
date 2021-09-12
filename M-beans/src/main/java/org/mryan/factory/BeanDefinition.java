package org.mryan.factory;

/**
 * @description： 用于定义Bean实例化定义信息
 * @Author MRyan
 * @Date 2021/9/11 21:33
 * @Version 1.0
 */
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

}
