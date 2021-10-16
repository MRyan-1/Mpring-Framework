package cn.wormholestack.mpring.beans.support;

import cn.wormholestack.mpring.core.AliasRegistry;

/**
 * @description： 定义对BeanDefinition的增删等操作
 * @Author MRyan
 * @Date 2021/9/11 23:52
 * @Version 1.0
 */
public interface BeanDefinitionRegistry extends AliasRegistry {

    /**
     * 向容器中注册DeanDefinition
     *
     * @param beanName
     * @param bd
     */
    void registerBeanDefinition(String beanName, BeanDefinition bd);

    /**
     * 从容器中移除BeanDefinition
     *
     * @param beanName
     * @return
     */
    int removeBeanDefinition(String beanName);

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 用于统计BeanDefinition的个数
     *
     * @return BeanDefinition总个数
     */
    int getBeanDefinitionCount();

    /**
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}

