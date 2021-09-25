package org.mryan.beans.support;

/**
 * @description： FactoryBean是一种特殊的bean，当向容器获取该bean时，容器不是返回其本身，而是返回其FactoryBean#getObject方法的返回值，可通过编码方式定义复杂的bean。
 * @Author MRyan
 * @Date 2021/9/18 22:25
 * @Version 1.0
 */
public interface FactoryBean<T> {

    /**
     * 当容器发现bean为FactoryBean类型时，调用其getObject方法返回最终bean。当FactoryBean#isSingleton==true，将最终bean放进缓存中，下次从缓存中获取。
     *
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}