package org.mryan.beans.test;

import org.junit.Test;

import org.mryan.beans.factory.DefaultListableBeanFactory;
import org.mryan.beans.factory.xml.XmlBeanDefinitionReader;
import org.mryan.beans.test.beans.UserService;

/**
 * @description： 资源加载xml自动解析注册Bean
 * @Author MRyan
 * @Date 2021/9/12 23:55
 * @Version 1.0
 */
public class ResourceLoaderTest {

    @Test
    public void TEST_RESOURCE_LOADER_XML_REGISTER_BEAN() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件并且完成注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUser();
    }
}
