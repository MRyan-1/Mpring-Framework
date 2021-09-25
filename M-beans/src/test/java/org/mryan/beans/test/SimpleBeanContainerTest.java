package org.mryan.beans.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.mryan.beans.PropertyValue;
import org.mryan.beans.PropertyValues;
import org.mryan.beans.config.RuntimeBeanReference;
import org.mryan.beans.support.BeanDefinition;
import org.mryan.beans.factory.DefaultListableBeanFactory;
import org.mryan.beans.test.beans.UserDao;
import org.mryan.beans.test.beans.UserInfoService;
import org.mryan.beans.test.beans.UserService;

/**
 * @description： feature_simple_bean_container 简单Bean容器实现单元测试
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

    /**
     * 为bean注入bean 测试Bean容器可用性
     */
    @Test
    public void TEST_POPULATE_BEAN_WITH_BEAN() {
        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        //3. UserService 设置属性[name、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "MPring"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new RuntimeBeanReference("userDao")));
        //4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();
    }

}
