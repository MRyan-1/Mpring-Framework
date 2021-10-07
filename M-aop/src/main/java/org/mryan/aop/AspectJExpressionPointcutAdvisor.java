package org.mryan.aop;

import org.aopalliance.aop.Advice;
import org.mryan.aop.advice.Pointcut;
import org.mryan.aop.advice.PointcutAdvisor;

/**
 * @description： AspectJExpressionPointcutAdvisor
 * @Author MRyan
 * @Date 2021/9/23 22:51
 * @Version 1.0
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 具体的拦截方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
