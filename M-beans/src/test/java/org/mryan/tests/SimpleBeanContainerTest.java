package org.mryan.tests;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.mryan.beans.UserInfoService;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.DefaultListableBeanFactory;

/**
 * @description：TODO
 * @Author MRyan
 * @Date 2021/9/11 22:13
 * @Version 1.0
 */
public class SimpleBeanContainerTest {

    /**
     * 简单Bean容器 功能测试
     */
    @Test
    public void TEST_SIMPLE_BEAN_CONTAINER() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserInfoService.class);
        beanFactory.registerBeanDefinition("userInfoService", beanDefinition);
        // 3.第一次获取 bean
        UserInfoService userService = (UserInfoService) beanFactory.getBean("userInfoService", "MPring");
        //UserInfoService userService = (UserInfoService) beanFactory.getBean("userInfoService");
        System.out.println(userService);
        // 4.第二次获取 bean from Singleton
        UserInfoService userService_singleton = (UserInfoService) beanFactory.getBean("userInfoService");
        System.out.println(userService_singleton);

    }

    /**
     * CGLIB生成代理对象测试
     */
    @Test
    public void TEST_CGLIB() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserInfoService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"MPring Test"});
        System.out.println(o);
    }

}
