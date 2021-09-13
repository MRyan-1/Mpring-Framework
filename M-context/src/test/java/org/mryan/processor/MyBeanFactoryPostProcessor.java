package org.mryan.processor;

import org.mryan.BeansException;
import org.mryan.PropertyValues;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.BeanFactoryPostProcessor;
import org.mryan.factory.ConfigurableListableBeanFactory;

/**
 * @description： MyBeanFactoryPostProcessor
 * @Author MRyan
 * @Date 2021/9/13 23:47
 * @Version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        System.out.println("Bean初始化之前执行postProcessBeanFactory");
    }

}