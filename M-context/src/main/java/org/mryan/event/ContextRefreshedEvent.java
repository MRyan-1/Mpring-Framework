package org.mryan.event;

import org.mryan.ApplicationContext;

/**
 * @description： ContextRefreshedEvent
 * @Author MRyan
 * @Date 2021/9/19 10:48
 * @Version 1.0
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}