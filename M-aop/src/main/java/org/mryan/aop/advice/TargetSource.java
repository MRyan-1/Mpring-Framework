package org.mryan.aop.advice;

/**
 * @description： 被代理的对象
 * @Author MRyan
 * @Date 2021/9/20 23:17
 * @Version 1.0
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }

}

