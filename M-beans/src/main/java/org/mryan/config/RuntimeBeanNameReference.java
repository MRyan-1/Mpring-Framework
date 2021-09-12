package org.mryan.config;

import org.mryan.utils.Assert;

/**
 * @description： RuntimeBeanNameReference
 * @Author MRyan
 * @Date 2021/9/12 17:33
 * @Version 1.0
 */
public class RuntimeBeanNameReference implements BeanReference {

    private final String beanName;

    public RuntimeBeanNameReference(String beanName) {
        Assert.hasText(beanName, "'beanName' must not be empty");
        this.beanName = beanName;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }

}
