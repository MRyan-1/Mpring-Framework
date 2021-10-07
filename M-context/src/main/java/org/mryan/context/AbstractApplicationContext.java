package org.mryan.context;

import org.mryan.espression.BeansException;
import org.mryan.beans.factory.BeanFactoryPostProcessor;
import org.mryan.beans.factory.BeanPostProcessor;
import org.mryan.beans.factory.ConfigurableListableBeanFactory;
import org.mryan.context.event.*;
import org.mryan.context.postProcessor.ApplicationContextAwareProcessor;
import org.mryan.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @description： AbstractApplicationContext
 * @Author MRyan
 * @Date 2021/9/13 20:49
 * @Version 1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    /**
     * Synchronization monitor for the "refresh" and "destroy".
     */
    private final Object startupShutdownMonitor = new Object();

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;


    public abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 创建BeanFactory，并加载BeanDefinition
     *
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    @Override
    public void refresh() throws BeansException, IllegalStateException {
        synchronized (this.startupShutdownMonitor) {
            //1. 创建BeanFactory，并加载BeanDefinition
            refreshBeanFactory();
            //2. 获取BeanFactory
            ConfigurableListableBeanFactory beanFactory = getBeanFactory();
            //3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware的Bean对象都能感知所属的ApplicationContext
            beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
            //4. 在bean实例化之前，执行BeanFactoryPostProcessor 判断是否有需求修改BeanDefinition
            invokeBeanFactoryPostProcessors(beanFactory);
            //5. BeanPostProcessor需要提前与其他bean实例化之前注册
            registerBeanPostProcessors(beanFactory);
            //6. 初始化事件发布者
            initApplicationEventMulticaster();
            //7. 注册事件监听器
            registerListeners();
            //8. 提前实例化单例bean
            beanFactory.preInstantiateSingletons();
            //9. 发布容器刷新完成事件
            finishRefresh();
        }
    }

    /**
     * 初始化事件发布者
     */
    protected void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    /**
     * 注册事件监听器
     */
    protected void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener applicationListener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(applicationListener);
        }
    }

    /**
     * 发布容器刷新完成事件
     */
    protected void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }


    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }


    /**
     * 在bean实例化之前，执行BeanFactoryPostProcessor
     *
     * @param beanFactory
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册BeanPostProcessor
     *
     * @param beanFactory
     */
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public <T> T getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 注册虚拟机钩子 hook虚拟机关闭执行bean的close
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }


    protected void doClose() {
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        //执行单例bean的销毁方法
        destroyBeans();
    }

    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }

    @Override
    public void close() {
        doClose();
    }
}
