package org.mryan.aop;

/**
 * @description： 代理抽象 策略模式
 * @Author MRyan
 * @Date 2021/9/20 23:20
 * @Version 1.0
 */
public interface AopProxy {

    /**
     * 获取代理类
     *
     * @return
     */
    Object getProxy();
}
