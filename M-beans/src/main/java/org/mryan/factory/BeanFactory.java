package org.mryan.factory;

import org.mryan.BeansException;

/**
 * @description： 定义getBean（获取bean）触发依赖注入过程的方法 和bean的其他属性
 * @Author MRyan
 * @Date 2021/9/11 21:27
 * @Version 1.0
 */
public interface BeanFactory {

    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String beanName) throws BeansException;

    <T> T getBean(String beanName, Object... args) throws BeansException;

}
