package org.mryan.beans.factory.aware;

import org.mryan.BeansException;
import org.mryan.beans.factory.Aware;

/**
 * @description： 实现此接口，既能感知到所属的BeanName
 * @Author MRyan
 * @Date 2021/9/16 22:44
 * @Version 1.0
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name) throws BeansException;
}
