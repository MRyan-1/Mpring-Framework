package org.mryan.context;

import org.mryan.espression.BeansException;
import org.mryan.beans.factory.DefaultListableBeanFactory;

/**
 * @description： AbstractRefreshableApplicationContext
 * @Author MRyan
 * @Date 2021/9/13 21:16
 * @Version 1.0
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        this.beanFactory = beanFactory;
        loadBeanDefinitions(beanFactory);
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
}
