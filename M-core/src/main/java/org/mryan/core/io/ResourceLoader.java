package org.mryan.core.io;

import com.sun.istack.internal.Nullable;

/**
 * @description： 定义资源加载器，主要应用于根据给定的资源文件地址返回对应的Resource
 * @Author MRyan
 * @Date 2021/9/12 21:19
 * @Version 1.0
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

    @Nullable
    ClassLoader getClassLoader();

}
