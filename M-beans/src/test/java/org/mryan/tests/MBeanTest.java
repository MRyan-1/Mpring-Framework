package org.mryan.tests;

import org.junit.Test;
import org.mryan.beans.UserInfoService;
import org.mryan.factory.BeanDefinition;
import org.mryan.factory.BeanFactory;
import org.mryan.factory.DefaultListableBeanFactory;

/**
 * @description：TODO
 * @Author MRyan
 * @Date 2021/9/11 22:13
 * @Version 1.0
 */
public class MBeanTest {

    @Test
    public void TEST_SIMPLE_BEAN_CONTAINER() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserInfoService.class);
        beanFactory.registerBeanDefinition("userInfoService", beanDefinition);
        // 3.第一次获取 bean
        UserInfoService userService = (UserInfoService) beanFactory.getBean("userInfoService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserInfoService userService_singleton = (UserInfoService) beanFactory.getBean("userInfoService");
        userService_singleton.queryUserInfo();

    }

}
