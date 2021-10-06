package org.mryan.context.test.event;

import org.mryan.context.event.ApplicationListener;
import org.mryan.context.event.ContextRefreshedEvent;

/**
 * @description： ContextRefreshedEventListener
 * @Author MRyan
 * @Date 2021/9/19 10:54
 * @Version 1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("【refreshedEventListener】:"+this.getClass().getName());
    }
}