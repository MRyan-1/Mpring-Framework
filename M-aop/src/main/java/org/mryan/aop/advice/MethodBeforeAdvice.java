package org.mryan.aop.advice;

import java.lang.reflect.Method;

/**
 * @description： 方法前置环绕 拦截器链路
 * @Author MRyan
 * @Date 2021/9/23 22:46
 * @Version 1.0
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * Callback before a given method is invoked.
     *
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
