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
     * XML文件-》BeanDefinition-》BeanFactoryPostProcessor修改BeanDefinition-》bean实例化-》BeanPostProcessor前置处理-》执行bean的初始化方法-》BeanPostProcessor后置处理-》使用
     * getBean: Bean对象-》属性信息-》对象创建-》属性填充-》初始化操作-》注册销毁-》单例判断
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
