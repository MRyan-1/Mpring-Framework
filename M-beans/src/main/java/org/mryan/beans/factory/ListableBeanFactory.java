package org.mryan.beans.factory;

import org.mryan.espression.BeansException;

import java.util.Map;

/**
 * @description： ListableBeanFactory
 * @Author MRyan
 * @Date 2021/9/13 20:38
 * @Version 1.0
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
