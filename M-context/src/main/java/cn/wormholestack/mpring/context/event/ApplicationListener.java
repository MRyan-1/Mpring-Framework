package cn.wormholestack.mpring.context.event;

import java.util.EventListener;

/**
 * @description：TODO
 * @Author MRyan
 * @Date 2021/9/19 09:53
 * @Version 1.0
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}