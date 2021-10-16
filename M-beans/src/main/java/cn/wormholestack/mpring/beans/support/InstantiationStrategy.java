package cn.wormholestack.mpring.beans.support;

import cn.wormholestack.mpring.espression.BeansException;
import cn.wormholestack.mpring.beans.factory.BeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description： 定义实例化策略接口
 * @Author MRyan
 * @Date 2021/9/12 12:48
 * @Version 1.0
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

    Object instantiate(BeanDefinition bd, String beanName,
                       Constructor<?> ctor, Object... args) throws BeansException;


    Object instantiate(BeanDefinition bd, String beanName, BeanFactory owner) throws BeansException;


    Object instantiate(BeanDefinition bd, String beanName, BeanFactory owner,
                       Object factoryBean, Method factoryMethod, Object... args) throws BeansException;
}
