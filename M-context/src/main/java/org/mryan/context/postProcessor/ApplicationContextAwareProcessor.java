package org.mryan.context.postProcessor;

import org.mryan.context.ApplicationContext;
import org.mryan.espression.BeansException;
import org.mryan.context.aware.ApplicationContextAware;
import org.mryan.beans.factory.BeanPostProcessor;

/**
 * @description：
 * @Author MRyan
 * @Date 2021/9/16 22:49
 * @Version 1.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
