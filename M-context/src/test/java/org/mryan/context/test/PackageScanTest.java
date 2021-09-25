package org.mryan.context.test;

import org.junit.Test;
import org.mryan.context.ClassPathXmlApplicationContext;
import org.mryan.context.test.beans.Car;
import org.mryan.context.test.beans.ClassService;

/**
 * @description： 包自动扫描单元测试
 * @Author MRyan
 * @Date 2021/9/25 21:09
 * @Version 1.0
 */
public class PackageScanTest {

    /**
     * 占位符测试
     */
    @Test
    public void TEST_PROPERTY() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        Car car = applicationContext.getBean("car", Car.class);
        System.out.println("测试结果：" + car);
    }

    /**
     * 包扫描测试
     */
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");
        ClassService classService = applicationContext.getBean("classService", ClassService.class);
        classService.sout();
    }
}
