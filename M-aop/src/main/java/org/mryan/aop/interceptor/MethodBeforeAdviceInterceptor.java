package org.mryan.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.mryan.aop.advice.MethodBeforeAdvice;

/**
 * @description： MethodBeforeAdviceInterceptor
 * @Author MRyan
 * @Date 2021/9/23 22:56
 * @Version 1.0
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //在执行被代理方法之前，先执行before advice操作
        this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }


}
