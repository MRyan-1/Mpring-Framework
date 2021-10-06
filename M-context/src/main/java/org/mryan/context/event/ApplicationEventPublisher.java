package org.mryan.context.event;

/**
 * @description： 事件发布接口
 * @Author MRyan
 * @Date 2021/9/19 10:30
 * @Version 1.0
 */
public interface ApplicationEventPublisher {

    /**
     * 事件发布
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);

}