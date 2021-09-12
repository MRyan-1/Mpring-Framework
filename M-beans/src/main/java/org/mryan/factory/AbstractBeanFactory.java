package org.mryan.factory;


import org.mryan.BeansException;
import org.mryan.utils.ObjectUtils;

/**
 * @description： AbstractBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 22:47
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

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

}
