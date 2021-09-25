package org.mryan.context.aop.config;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.mryan.context.aop.ProxyFactory;
import org.mryan.context.aop.advice.*;
import org.mryan.BeansException;
import org.mryan.context.aop.AspectJExpressionPointcutAdvisor;
import org.mryan.beans.config.InstantiationAwareBeanPostProcessor;
import org.mryan.beans.factory.BeanFactory;
import org.mryan.beans.factory.DefaultListableBeanFactory;
import org.mryan.beans.factory.aware.BeanFactoryAware;

import java.util.Collection;

/**
 * @description： DefaultAdvisorAutoProxyCreator
 * @Author MRyan
 * @Date 2021/9/23 23:06
 * @Version 1.0
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) return null;
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        try {
            for (AspectJExpressionPointcutAdvisor advisor : advisors) {
                ClassFilter classFilter = advisor.getPointcut().getClassFilter();
                if (!classFilter.matches(beanClass)) continue;

                AdvisedSupport advisedSupport = new AdvisedSupport();

                TargetSource targetSource = null;
                try {
                    targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                advisedSupport.setTargetSource(targetSource);
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                //设置代理模式 JDK或者CGLIB
                advisedSupport.setProxyTargetClass(true);

                return new ProxyFactory(advisedSupport).getProxy();

            }

        } catch (Exception ex) {
            throw new BeansException("Error create proxy bean for: " + beanName, ex);
        }
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }


    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass)
                || Pointcut.class.isAssignableFrom(beanClass)
                || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
