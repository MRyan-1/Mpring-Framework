package org.mryan.factory;

import org.mryan.BeansException;

/**
 * @description： Bean工厂
 * @Author MRyan
 * @Date 2021/9/11 21:27
 * @Version 1.0
 */
public interface BeanFactory {

    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String beanName) throws BeansException;

    <T> T getBean(String beanName, Object... args) throws BeansException;

}
