package cn.wormholestack.mpring.beans.config;

import cn.wormholestack.mpring.support.utils.Assert;
import cn.wormholestack.mpring.beans.factory.BeanReference;

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
