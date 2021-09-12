package org.mryan.factory;

import org.mryan.BeansException;
import org.mryan.support.CglibSubclassingInstantiationStrategy;
import org.mryan.support.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * @description： AbstractAutowireCapableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:40
 * @Version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实例化策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object... args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(bd, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        registerSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition bd, String beanName, Object... args) {
        Constructor<?> constructor = null;
        Class<?> beanClass = bd.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(bd, beanName, constructor, args);
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
