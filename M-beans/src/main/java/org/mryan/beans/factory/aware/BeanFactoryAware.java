package org.mryan.beans.factory.aware;

import org.mryan.espression.BeansException;
import org.mryan.beans.factory.BeanFactory;
import org.mryan.beans.factory.Aware;

/**
 * @description：
 * @Author MRyan
 * @Date 2021/9/16 22:41
 * @Version 1.0
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}