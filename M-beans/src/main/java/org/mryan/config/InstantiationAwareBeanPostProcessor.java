package org.mryan.config;

import org.mryan.BeansException;
import org.mryan.factory.BeanPostProcessor;

/**
 * @description： InstantiationAwareBeanPostProcessor
 * @Author MRyan
 * @Date 2021/9/23 23:05
 * @Version 1.0
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在bean实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
