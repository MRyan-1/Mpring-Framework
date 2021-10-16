package cn.wormholestack.mpring.beans.config;

import cn.wormholestack.mpring.support.utils.Assert;
import cn.wormholestack.mpring.beans.factory.BeanReference;

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
