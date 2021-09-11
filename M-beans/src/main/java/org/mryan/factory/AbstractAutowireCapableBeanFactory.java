package org.mryan.factory;

import org.mryan.BeansException;

/**
 * @description： AbstractAutowireCapableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:40
 * @Version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        registerSingleton(beanName, bean);
        return bean;
    }
}
