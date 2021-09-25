package org.mryan.context.test.event;

import org.mryan.context.ApplicationContext;

/**
 * @description： 事件抽象类，事件包括关闭，刷新，以及自定义事件，都需要继承此类
 * @Author MRyan
 * @Date 2021/9/19 09:16
 * @Version 1.0
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
