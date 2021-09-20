package org.mryan.aop;

import java.lang.reflect.Method;

/**
 * @description： 方法匹配，找到表达式范围内匹配下的目标类和方法。
 * @Author MRyan
 * @Date 2021/9/20 22:44
 * @Version 1.0
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     *
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
