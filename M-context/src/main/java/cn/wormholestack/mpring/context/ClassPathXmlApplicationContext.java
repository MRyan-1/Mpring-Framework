package cn.wormholestack.mpring.context;

import cn.wormholestack.mpring.espression.BeansException;

/**
 * @description： ClassPathXmlApplicationContext
 * @Author MRyan
 * @Date 2021/9/13 21:25
 * @Version 1.0
 */
public class ClassPathXmlApplicationContext extends  AbstractXmlApplicationContext {


    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
