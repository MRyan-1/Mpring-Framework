package org.mryan;

import org.mryan.core.io.ResourceLoader;
import org.mryan.event.ApplicationEventPublisher;
import org.mryan.factory.HierarchicalBeanFactory;
import org.mryan.factory.ListableBeanFactory;

/**
 * @description： 实现应用上下文功能
 * @Author MRyan
 * @Date 2021/9/13 20:41
 * @Version 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
