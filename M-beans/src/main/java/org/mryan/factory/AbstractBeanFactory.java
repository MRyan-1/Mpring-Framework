package org.mryan.factory;


import org.mryan.BeansException;
import org.mryan.config.ConfigurableBeanFactory;
import org.mryan.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： AbstractBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 22:47
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {


    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition bd, Object... args) throws BeansException;

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, (Object) null);
    }

    @Override
    public <T> T getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String beanName, final Object... args) {
        Object singleton = getSingleton(beanName);
        if (!ObjectUtils.isEmpty(singleton)) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

}
