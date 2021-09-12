package org.mryan.config;

import org.mryan.utils.Assert;

/**
 * @description： RuntimeBeanReference
 * @Author MRyan
 * @Date 2021/9/12 17:52
 * @Version 1.0
 */
public class RuntimeBeanReference implements BeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        Assert.hasText(beanName, "'beanName' must not be empty");
        this.beanName = beanName;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }
}
