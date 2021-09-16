package org.mryan.factory.aware;

import org.mryan.BeansException;
import org.mryan.support.Aware;

/**
 * @description： 实现此接口，既能感知到所属的ClassLoader
 * @Author MRyan
 * @Date 2021/9/16 22:43
 * @Version 1.0
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;

}
