package org.mryan.factory;

import org.mryan.utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description： SingletonBeanRegistry默认实现类
 * @Author MRyan
 * @Date 2021/9/11 23:01
 * @Version 1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 用于保存beanName和创建bean实例之间的关系, beanName->beanInstance,
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return singletonObjects.containsKey(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName, "Bean name must not be null");
        Assert.notNull(singletonObject, "Singleton object must not be null");
        singletonObjects.put(beanName, singletonObject);
    }
}
