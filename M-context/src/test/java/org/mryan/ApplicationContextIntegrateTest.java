package org.mryan;

import org.junit.Test;
import org.mryan.beans.UserService;

/**
 * @description： 测试应用上下文 自动识别资源加载并扩展
 * @Author MRyan
 * @Date 2021/9/13 22:12
 * @Version 1.0
 */
public class ApplicationContextIntegrateTest {

    /**
     * 目前Bean的生命周期
     * XML文件-》
     * BeanDefinition-》
     * BeanFactoryPostProcessor修改BeanDefinition-》
     * bean实例化-》
     * BeanFactoryAware#setBeanFactory-》
     * BeanPostProcessor前置处理-》
     * 执行bean的初始化方法（InitializingBean#afterPropertiesSet-》自定义初始化方法init-method）-》
     * BeanPostProcessors后置处理-》
     * 使用-》
     * 执行bean的销毁方法-》DisposableBean#destroy-》自定义销毁方法destroy-method
     */
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUser();

    }
}

