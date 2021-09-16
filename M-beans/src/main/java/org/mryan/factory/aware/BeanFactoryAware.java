package org.mryan.factory.aware;

import org.mryan.BeansException;
import org.mryan.factory.BeanFactory;
import org.mryan.support.Aware;

/**
 * @description：
 * @Author MRyan
 * @Date 2021/9/16 22:41
 * @Version 1.0
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}