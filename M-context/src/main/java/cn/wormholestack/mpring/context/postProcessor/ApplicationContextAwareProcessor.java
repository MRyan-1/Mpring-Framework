package cn.wormholestack.mpring.context.postProcessor;

import cn.wormholestack.mpring.espression.BeansException;
import cn.wormholestack.mpring.context.ApplicationContext;
import cn.wormholestack.mpring.context.aware.ApplicationContextAware;
import cn.wormholestack.mpring.beans.factory.BeanPostProcessor;

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
