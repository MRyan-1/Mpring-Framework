package org.mryan.factory;

import com.sun.istack.internal.Nullable;
import org.mryan.BeansException;

/**
 * @description： 为MPring提供的容器扩展机制：在bean实例化后修改bean或替换bean
 * @Author MRyan
 * @Date 2021/9/13 13:04
 */
public interface BeanPostProcessor {

    /**
     * Bean初始化前置处理
     * 在Bean对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * Bean初始化后置处理
     * 在Bean对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
