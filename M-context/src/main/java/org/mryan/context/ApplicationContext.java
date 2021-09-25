package org.mryan.context;

import org.mryan.core.io.ResourceLoader;
import org.mryan.context.test.event.ApplicationEventPublisher;
import org.mryan.beans.factory.HierarchicalBeanFactory;
import org.mryan.beans.factory.ListableBeanFactory;

/**
 * @description： 实现应用上下文功能
 * @Author MRyan
 * @Date 2021/9/13 20:41
 * @Version 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
