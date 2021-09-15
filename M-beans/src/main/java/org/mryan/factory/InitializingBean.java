package org.mryan.factory;

/**
 * @description： 定制Bean初始化方法
 * @Author MRyan
 * @Date 2021/9/15 22:51
 * @Version 1.0
 */
public interface InitializingBean {

    /**
     * Bean处理属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
