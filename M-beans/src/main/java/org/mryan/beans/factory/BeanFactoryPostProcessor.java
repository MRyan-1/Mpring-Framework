package org.mryan.beans.factory;

import org.mryan.BeansException;

/**
 * @description： 为MPring提供的容器扩展机制 允许在bean实例化之前修改bean的定义信息及BeanDefinition的信息
 * @Author MRyan
 * @Date 2021/9/13 13:04
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefintion加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
