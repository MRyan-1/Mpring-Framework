package cn.wormholestack.mpring.context.test;

import cn.wormholestack.mpring.context.test.beans.IAnnotationService;
import org.junit.Test;
import cn.wormholestack.mpring.context.ClassPathXmlApplicationContext;

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
