package org.mryan.context.test;

import org.junit.Test;
import org.mryan.context.ClassPathXmlApplicationContext;
import org.mryan.context.test.beans.IAnnotationService;

/**
 * @description： 测试@Autowired @Value注解
 * @Author MRyan
 * @Date 2021/10/6 19:46
 * @Version 1.0
 */
public class AnnotationTest {

    @Test
    public void TEST_ANNOTATION_SCAN() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:annotation.xml");
        IAnnotationService annotationService = applicationContext.getBean("annotationService", IAnnotationService.class);
        System.out.println("测试结果：" + annotationService.queryUserInfo());
    }

}
