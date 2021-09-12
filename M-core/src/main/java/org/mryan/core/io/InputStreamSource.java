package org.mryan.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description： 无论是File还是Classpath下的资源还是Byte Array等，getInputStream都能返回一个新的InputStream对象
 * @Author MRyan
 * @Date 2021/9/12 21:13
 * @Version 1.0
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;
}
