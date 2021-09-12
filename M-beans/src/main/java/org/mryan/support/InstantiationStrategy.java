package org.mryan.support;

import com.sun.istack.internal.Nullable;
import org.mryan.BeansException;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.BeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description： 定义实例化策略接口
 * @Author MRyan
 * @Date 2021/9/12 12:48
 * @Version 1.0
 */
public interface InstantiationStrategy {


    Object instantiate(BeanDefinition bd, @Nullable String beanName,
                       Constructor<?> ctor, Object... args) throws BeansException;


    Object instantiate(BeanDefinition bd, @Nullable String beanName, BeanFactory owner) throws BeansException;


    Object instantiate(BeanDefinition bd, @Nullable String beanName, BeanFactory owner,
                       @Nullable Object factoryBean, Method factoryMethod, Object... args) throws BeansException;
}
