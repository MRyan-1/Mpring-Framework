package org.mryan.config;

import org.mryan.factory.BeanPostProcessor;
import org.mryan.factory.HierarchicalBeanFactory;
import org.mryan.factory.SingletonBeanRegistry;

/**
 * @description： ConfigurableBeanFactory
 * @Author MRyan
 * @Date 2021/9/13 21:06
 * @Version 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}