package org.mryan.factory;

import org.mryan.BeansException;
import org.mryan.config.AutowireCapableBeanFactory;
import org.mryan.config.ConfigurableBeanFactory;

/**
 * @description： ConfigurableListableBeanFactory
 * @Author MRyan
 * @Date 2021/9/13 13:13
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {


    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
