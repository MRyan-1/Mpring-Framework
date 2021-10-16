package cn.wormholestack.mpring.beans.factory.aware;

import cn.wormholestack.mpring.espression.BeansException;
import cn.wormholestack.mpring.beans.factory.Aware;

/**
 * @description： 实现此接口，既能感知到所属的ClassLoader
 * @Author MRyan
 * @Date 2021/9/16 22:43
 * @Version 1.0
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;

}
