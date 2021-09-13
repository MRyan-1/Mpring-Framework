package org.mryan.factory;

import cn.hutool.core.bean.BeanUtil;
import org.mryan.BeansException;
import org.mryan.PropertyValue;
import org.mryan.PropertyValues;
import org.mryan.config.AutowireCapableBeanFactory;
import org.mryan.config.BeanReference;
import org.mryan.support.CglibSubclassingInstantiationStrategy;
import org.mryan.support.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * @description： AbstractAutowireCapableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:40
 * @Version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    /**
     * 实例化策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object... args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(bd, beanName, args);
            //Bean属性填充
            applyPropertyValues(beanName, bean, bd);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, bd);
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

    private Object initializeBean(String beanName, Object bean, BeanDefinition bd) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, bd);
        invokeInitMethods(beanName, wrappedBean, bd);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition bd) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    /**
     * Bean属性填充
     *
     * @param beanName
     * @param bean
     * @param bd
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition bd) {
        try {
            PropertyValues propertyValues = bd.getPropertyValues();
            if (propertyValues != null) {
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    String name = propertyValue.getName();
                    Object value = propertyValue.getValue();
                    //如果是BeanReference则需要递归获取Bean实例并调用getBean方法  类似A依赖B  则获取B的实例化
                    if (value instanceof BeanReference) {
                        BeanReference beanReference = (BeanReference) value;
                        //递归循环创建Bean
                        value = getBean(beanReference.getBeanName());
                    }
                    //属性填充
                    BeanUtil.setFieldValue(bean, name, value);
                }
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
