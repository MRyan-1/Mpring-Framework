package org.mryan.beans.config;

import org.mryan.BeansException;
import org.mryan.beans.PropertyValues;
import org.mryan.beans.factory.BeanPostProcessor;

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

    /**
     * bean实例化之后，设置属性之前执行
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
            throws BeansException;
}
