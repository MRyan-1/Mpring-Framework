package org.mryan.beans.factory;

import org.mryan.beans.support.BeanDefinition;
import org.mryan.beans.support.BeanDefinitionRegistry;
import org.mryan.BeansException;
import org.mryan.support.utils.Assert;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description： DefaultListableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:45
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(512);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition bd) {
        Assert.notNull(beanName, "Bean name must not be null");
        Assert.notNull(bd, "beanDefinition must not be null");
        beanDefinitionMap.put(beanName, bd);
    }

    @Override
    public int removeBeanDefinition(String beanName) {
        return 0;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }


    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class<?> beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                T bean = (T) getBean(beanName);
                result.put(beanName, bean);
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }


    @Override
    public void registerAlias(String name, String alias) {

    }

    @Override
    public void removeAlias(String alias) {

    }

}
