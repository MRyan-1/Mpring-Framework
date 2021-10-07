package org.mryan.context.event;

import org.mryan.espression.BeansException;
import org.mryan.beans.factory.BeanFactory;
import org.mryan.beans.factory.aware.BeanFactoryAware;

import java.util.HashSet;
import java.util.Set;

/**
 * @description： AbstractApplicationEventMulticaster
 * @Author MRyan
 * @Date 2021/9/19 10:21
 * @Version 1.0
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

}
