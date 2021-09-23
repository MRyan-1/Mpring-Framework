package org.mryan.support;

import org.mryan.BeansException;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.BeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description： JDK简单InstantiationStrategy实现  使用bean的构造函数来实例化
 * @Author MRyan
 * @Date 2021/9/12 13:01
 * @Version 1.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }

    @Override
    public Object instantiate(BeanDefinition bd, String beanName, Constructor<?> ctor, Object... args) throws BeansException {
        //通过BeanDefinition获取Class信息
        Class beanClass = bd.getBeanClass();
        try {
            //如果ctor不为空 表示需要有构造函数实例化
            if (null != ctor) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                //无构造函数实例化
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }

    @Override
    public Object instantiate(BeanDefinition bd, String beanName, BeanFactory owner) throws BeansException {
        return null;
    }

    @Override
    public Object instantiate(BeanDefinition bd, String beanName, BeanFactory owner, Object factoryBean, Method factoryMethod, Object... args) throws BeansException {
        return null;
    }
}
