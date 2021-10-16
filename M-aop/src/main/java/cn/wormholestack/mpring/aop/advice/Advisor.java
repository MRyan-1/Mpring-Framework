package cn.wormholestack.mpring.aop.advice;

import org.aopalliance.aop.Advice;

/**
 * @description： 访问者
 * @Author MRyan
 * @Date 2021/9/23 22:48
 * @Version 1.0
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     *
     * @return the advice that should apply if the pointcut matches
     */
    Advice getAdvice();
}
