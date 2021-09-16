package org.mryan.postProcessor;

import org.mryan.ApplicationContext;
import org.mryan.BeansException;
import org.mryan.aware.ApplicationContextAware;
import org.mryan.factory.BeanPostProcessor;

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
