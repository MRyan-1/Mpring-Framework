package org.mryan.beans.factory.annotation;

import org.mryan.BeansException;
import org.mryan.beans.PropertyValues;
import org.mryan.beans.config.InstantiationAwareBeanPostProcessor;
import org.mryan.beans.factory.BeanFactory;
import org.mryan.beans.factory.ConfigurableListableBeanFactory;
import org.mryan.beans.factory.aware.BeanFactoryAware;

/**
 * @description： 处理@Autowired和@Value注解的BeanPostProcessor
 * @Author MRyan
 * @Date 2021/10/6 18:22
 * @Version 1.0
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        //处理@Value注解

        //处理@Autowired注解


        return null;
    }


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
