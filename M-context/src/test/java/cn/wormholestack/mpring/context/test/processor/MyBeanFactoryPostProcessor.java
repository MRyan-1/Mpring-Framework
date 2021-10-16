package cn.wormholestack.mpring.context.test.processor;

import cn.wormholestack.mpring.espression.BeansException;
import cn.wormholestack.mpring.beans.PropertyValues;
import cn.wormholestack.mpring.beans.support.BeanDefinition;
import cn.wormholestack.mpring.beans.factory.BeanFactoryPostProcessor;
import cn.wormholestack.mpring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @description： MyBeanFactoryPostProcessor
 * @Author MRyan
 * @Date 2021/9/13 23:47
 * @Version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        System.out.println("Bean初始化之前执行postProcessBeanFactory");
    }

}