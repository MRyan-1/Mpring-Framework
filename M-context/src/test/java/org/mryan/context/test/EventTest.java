package org.mryan.context.test;

import org.junit.Test;
import org.mryan.context.ClassPathXmlApplicationContext;
import org.mryan.context.test.event.CustomEvent;

/**
 * @description： 事件监听器发布测试
 * @Author MRyan
 * @Date 2021/9/19 10:56
 * @Version 1.0
 */
public class EventTest {

    /**
     * 目前refresh流程
     * 加载XML文件-》修改Bean定义-》注册Bean扩展-》事件初始注册（Event事件监听）-》实例化Bean对象-》发布容器刷新事件
     */
    @Test
    public void TEST_EVENT() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 123456L, "发送消息成功"));
        applicationContext.registerShutdownHook();
    }

}
