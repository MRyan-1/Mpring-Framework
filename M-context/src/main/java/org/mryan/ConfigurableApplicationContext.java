package org.mryan;

/**
 * @description： ConfigurableApplicationContext
 * @Author MRyan
 * @Date 2021/9/13 20:43
 * @Version 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 容器刷新
     *
     * @throws BeansException
     * @throws IllegalStateException
     */
    void refresh() throws BeansException, IllegalStateException;
}
