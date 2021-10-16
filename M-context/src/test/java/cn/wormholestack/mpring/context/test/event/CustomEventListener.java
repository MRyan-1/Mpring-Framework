package cn.wormholestack.mpring.context.test.event;

import cn.wormholestack.mpring.context.event.ApplicationListener;

import java.util.Date;

/**
 * @description： CustomEventListener
 * @Author MRyan
 * @Date 2021/9/19 10:50
 * @Version 1.0
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("【收到】：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("【消息】：" + event.getId() + ":" + event.getMessage());
    }

}
