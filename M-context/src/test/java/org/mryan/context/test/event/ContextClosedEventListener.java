package org.mryan.context.test.event;

/**
 * @description： ContextClosedEventListener
 * @Author MRyan
 * @Date 2021/9/19 10:54
 * @Version 1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("【closedEventListener】:" + this.getClass().getName());
    }
}
