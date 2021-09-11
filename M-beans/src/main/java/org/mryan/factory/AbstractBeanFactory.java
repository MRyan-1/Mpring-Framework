package org.mryan.factory;


import org.mryan.utils.ObjectUtils;
import org.mryan.BeansException;

/**
 * @description： AbstractBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 22:47
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    @Override
    public Object getBean(String beanName) {
        Object singleton = getSingleton(beanName);
        if (!ObjectUtils.isEmpty(singleton)) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) {
        return null;
    }
}
