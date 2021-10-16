package cn.wormholestack.mpring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @description： 包装切面通知信息
 * @Author MRyan
 * @Date 2021/9/20 23:14
 * @Version 1.0
 */
public class AdvisedSupport {

    //是否使用cglib代理
    private boolean proxyTargetClass = true;

    /**
     * 被代理的目标对象
     * 在目标对象类中提供Object入参属性，以及获取目标类TargetClass信息
     */
    private TargetSource targetSource;

    /**
     * 方法拦截器
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 方法匹配器(检查目标方法是否符合通知条件)
     */
    private MethodMatcher methodMatcher;

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}