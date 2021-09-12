package org.mryan.core.io;

import com.sun.istack.internal.Nullable;
import org.mryan.utils.Assert;
import org.mryan.utils.ClassUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description： DefaultResourceLoader
 * @Author MRyan
 * @Date 2021/9/12 22:21
 * @Version 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Nullable
    private ClassLoader classLoader;


    public DefaultResourceLoader() {
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }


    public DefaultResourceLoader(@Nullable ClassLoader classLoader) {
        this.classLoader = classLoader;
    }


    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        return (this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader());
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}