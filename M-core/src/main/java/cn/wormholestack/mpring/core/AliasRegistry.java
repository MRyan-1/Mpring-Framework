package cn.wormholestack.mpring.core;

/**
 * @description： 定义对alias的简单增删改等操作
 * @Author MRyan
 * @Date 2021/9/11 23:50
 * @Version 1.0
 */
public interface AliasRegistry {

    void registerAlias(String name, String alias);

    void removeAlias(String alias);

}
