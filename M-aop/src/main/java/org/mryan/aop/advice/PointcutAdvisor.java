package org.mryan.aop.advice;

/**
 * @description： Advisor承担了Pointcut和Advice的组合，Pointcut用于获取JoinPoint，而Advice决定于JoinPoint执行什么操作。
 * @Author MRyan
 * @Date 2021/9/23 22:49
 * @Version 1.0
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
