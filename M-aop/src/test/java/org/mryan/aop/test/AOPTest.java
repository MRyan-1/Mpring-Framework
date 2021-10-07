package org.mryan.aop.test;

import org.junit.Test;
import org.mryan.aop.AspectJExpressionPointcut;
import org.mryan.aop.Cglib2AopProxy;
import org.mryan.aop.JdkDynamicAopProxy;
import org.mryan.aop.advice.AdvisedSupport;
import org.mryan.aop.advice.TargetSource;
import org.mryan.aop.test.interceptor.ClassServiceInterceptor;
import org.mryan.aop.test.service.ClassService;
import org.mryan.aop.test.service.IClassService;
import org.mryan.context.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * @description： 实现AOP测试类
 * @Author MRyan
 * @Date 2021/9/20 19:57
 * @Version 1.0
 */
public class AOPTest {

    /**
     * 测试拦截的方法与对应的对象是否匹配
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void TEST_AOP_ASPECT_JEXPRESSION_POINTCUT() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.mryan.aop.test.service.IClassService.*(..))");
        Class<IClassService> clazz = IClassService.class;
        Method method = clazz.getDeclaredMethod("getClassName");
        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void TEST_PROXY_METHOD() {
        // 目标对象
        ClassService classService = new ClassService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(classService));
        advisedSupport.setMethodInterceptor(new ClassServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* org.mryan.aop.test.service.IClassService.*(..))"));
        // 代理对象(JdkDynamicAopProxy)
        IClassService proxy_jdk = (IClassService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.getClassName());
        // 代理对象(Cglib2AopProxy)
        ClassService proxy_cglib = (ClassService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.getClassName());
    }


    @Test
    public void TEST_AOP_AUTO_PROXY() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:class.xml");
        IClassService classService = applicationContext.getBean("classService", IClassService.class);
        System.out.println("测试结果：" + classService.getClassName());
    }

}
