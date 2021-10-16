package cn.wormholestack.mpring.beans.factory.aware;

import cn.wormholestack.mpring.espression.BeansException;
import cn.wormholestack.mpring.beans.factory.BeanFactory;
import cn.wormholestack.mpring.beans.factory.Aware;

/**
 * @description：
 * @Author MRyan
 * @Date 2021/9/16 22:41
 * @Version 1.0
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}