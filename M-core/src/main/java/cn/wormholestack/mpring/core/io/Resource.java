package cn.wormholestack.mpring.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @description： Resource接口抽象了所有Mpring内部使用到的底层资源：File、URL、Classpath等
 * @Author MRyan
 * @Date 2021/9/12 21:13
 * @Version 1.0
 */
public interface Resource extends InputStreamSource {

    boolean exists();

    default boolean isReadable() {
        return exists();
    }

    default boolean isOpen() {
        return false;
    }

    default boolean isFile() {
        return false;
    }

    URL getURL() throws IOException;

    default URI getURI() throws IOException {
        return null;
    }

    File getFile() throws IOException;

    String getFilename();

    String getDescription();

}
