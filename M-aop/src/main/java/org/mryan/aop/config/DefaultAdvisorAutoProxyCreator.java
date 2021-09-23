package org.mryan.aop.config;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.mryan.BeansException;
import org.mryan.aop.*;
import org.mryan.aop.advice.Advisor;
import org.mryan.aop.advice.AspectJExpressionPointcutAdvisor;
import org.mryan.config.InstantiationAwareBeanPostProcessor;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.BeanFactory;
import org.mryan.factory.DefaultListableBeanFactory;
import org.mryan.factory.aware.BeanFactoryAware;

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

                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                Object bean = beanFactory.getInstantiationStrategy().instantiate(beanDefinition);
                TargetSource targetSource = new TargetSource(bean);
                advisedSupport.setTargetSource(targetSource);
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                //返回代理对象
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
