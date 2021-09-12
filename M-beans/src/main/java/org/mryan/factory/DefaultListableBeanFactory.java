package org.mryan.factory;

import org.mryan.BeansException;
import org.mryan.utils.Assert;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description： DefaultListableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:45
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, Serializable {

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
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }


    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
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
