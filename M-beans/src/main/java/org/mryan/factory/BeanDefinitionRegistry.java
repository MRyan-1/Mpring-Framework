package org.mryan.factory;

import org.mryan.core.AliasRegistry;

/**
 * @description： 定义对BeanDefinition的增删改等操作
 * @Author MRyan
 * @Date 2021/9/11 23:52
 * @Version 1.0
 */
public interface BeanDefinitionRegistry extends AliasRegistry {

    /**
     * 向容器中注册DeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从容器中移除BeanDefinition
     *
     * @param beanName
     * @return
     */
    int removeBeanDefinition(String beanName);

    /**
     * 用于统计BeanDefinition的个数
     *
     * @return BeanDefinition总个数
     */
    int getBeanDefinitionCount();
}

