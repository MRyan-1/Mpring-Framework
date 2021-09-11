package org.mryan.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description： Bean工厂
 * @Author MRyan
 * @Date 2021/9/11 21:27
 * @Version 1.0
 */
public interface BeanFactory {

    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String beanName);

    <T> T getBean(String name, Class<T> requiredType);

    Object getBean(String name, Object... args);

    <T> T getBean(Class<T> requiredType);

    <T> T getBean(Class<T> requiredType, Object... args);

}
