package cn.wormholestack.mpring.aop;

import cn.wormholestack.mpring.aop.advice.AdvisedSupport;

/**
 * @description： ProxyFactory 代理工厂创建JDK和CGLIB两种代理对象
 * @Author MRyan
 * @Date 2021/9/23 23:03
 * @Version 1.0
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }

}