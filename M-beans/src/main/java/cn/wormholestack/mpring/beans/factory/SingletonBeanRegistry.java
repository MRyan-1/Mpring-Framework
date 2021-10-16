package cn.wormholestack.mpring.beans.factory;

/**
 * @description： 主要定义对单例的注册和获取
 * @Author MRyan
 * @Date 2021/9/11 22:59
 * @Version 1.0
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
