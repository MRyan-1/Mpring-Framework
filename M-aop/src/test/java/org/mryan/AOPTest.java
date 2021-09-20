package org.mryan;

import org.junit.Test;
import org.mryan.beans.ClassService;

/**
 * @description： 实现AOP测试类
 * @Author MRyan
 * @Date 2021/9/20 19:57
 * @Version 1.0
 */
public class AOPTest {

    @Test
    public void TEST_PROXY_METHOD() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:class.xml");
        // 2. 获取Bean对象调用方法
        ClassService classService = applicationContext.getBean("classService", ClassService.class);
        System.out.println(classService.getClassName());
    }
}
