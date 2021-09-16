package org.mryan.aware;

import org.mryan.ApplicationContext;
import org.mryan.BeansException;
import org.mryan.support.Aware;

/**
 * @description： 实现此接口，既能感知到所属的 ApplicationContext
 * @Author MRyan
 * @Date 2021/9/16 22:47
 * @Version 1.0
 */
public interface ApplicationContextAware extends Aware {


    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
