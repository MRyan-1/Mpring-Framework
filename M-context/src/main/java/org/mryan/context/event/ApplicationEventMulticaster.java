package org.mryan.context.event;


/**
 * @description： 事件广播器
 * @Author MRyan
 * @Date 2021/9/19 09:48
 * @Version 1.0
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加监听
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除监听
     *
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件，接受处理事件
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);

}
