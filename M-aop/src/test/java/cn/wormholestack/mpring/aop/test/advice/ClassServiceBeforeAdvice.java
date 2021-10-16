package cn.wormholestack.mpring.aop.test.advice;

import cn.wormholestack.mpring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description： ClassServiceBeforeAdvice
 * @Author MRyan
 * @Date 2021/9/23 23:21
 * @Version 1.0
 */
public class ClassServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截：" + method.getName());
    }
}
