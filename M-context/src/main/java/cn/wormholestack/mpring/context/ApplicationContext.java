package cn.wormholestack.mpring.context;

import cn.wormholestack.mpring.context.event.ApplicationEventPublisher;
import cn.wormholestack.mpring.core.io.ResourceLoader;
import cn.wormholestack.mpring.beans.factory.HierarchicalBeanFactory;
import cn.wormholestack.mpring.beans.factory.ListableBeanFactory;

/**
 * @description： 实现应用上下文功能
 * @Author MRyan
 * @Date 2021/9/13 20:41
 * @Version 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
