package org.mryan.beans.factory;


import org.mryan.BeansException;
import org.mryan.beans.support.BeanDefinition;
import org.mryan.beans.support.FactoryBean;
import org.mryan.core.StringValueResolver;
import org.mryan.support.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： AbstractBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 22:47
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {


    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * String resolvers to apply e.g. to annotation attribute values
     */
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();


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
            //如果是FactoryBean 则需要调用FactoryBean#getObject
            return (T) getObjectForBeanInstance(singleton, beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    /**
     * getObject方法
     *
     * @param beanInstance
     * @param beanName
     * @return
     */
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
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

    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return ((T) getBean(name));
    }
}
