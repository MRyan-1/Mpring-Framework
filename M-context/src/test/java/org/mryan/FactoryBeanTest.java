package org.mryan;

import org.junit.Test;
import org.mryan.beans.UserService;

/**
 * @description： 针对FactoryBean单元测试
 * @Author MRyan
 * @Date 2021/9/18 22:38
 * @Version 1.0
 */
public class FactoryBeanTest {


    @Test
    public void TEST_PROTOTYPE() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        // 3. 配置 scope="prototype/singleton"
        //测试单例模式
        System.out.println("【获取Bean是否相等】：" + (userService1 == userService2));
    }


}
