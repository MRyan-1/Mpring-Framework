package cn.wormholestack.mpring.beans.support;

/**
 * @description： 定制Bean销毁接口
 * @Author MRyan
 * @Date 2021/9/15 22:53
 * @Version 1.0
 */
public interface DisposableBean {

    /**
     * 销毁
     * @throws Exception
     */
    void destroy() throws Exception;

}
