package cn.wormholestack.mpring.beans.factory;

import cn.wormholestack.mpring.beans.config.AutowireCapableBeanFactory;
import cn.wormholestack.mpring.beans.support.BeanDefinition;
import cn.wormholestack.mpring.espression.BeansException;

/**
 * @description： ConfigurableListableBeanFactory
 * @Author MRyan
 * @Date 2021/9/13 13:13
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {


    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
