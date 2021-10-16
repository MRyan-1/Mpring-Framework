package cn.wormholestack.mpring.context;

import cn.wormholestack.mpring.espression.BeansException;

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

    /**
     * 注册虚拟机钩子
     */
    void registerShutdownHook();

    /**
     * 手动close方法
     */
    void close();
}
