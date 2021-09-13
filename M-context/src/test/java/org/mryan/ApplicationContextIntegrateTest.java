package org.mryan;

import org.junit.Test;
import org.mryan.beans.UserService;

/**
 * @description：TODO
 * @Author MRyan
 * @Date 2021/9/13 22:12
 * @Version 1.0
 */
public class ApplicationContextIntegrateTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUser();
        System.out.println(userService.getName());
    }
}
