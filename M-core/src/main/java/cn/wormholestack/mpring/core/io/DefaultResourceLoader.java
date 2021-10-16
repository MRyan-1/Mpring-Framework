package cn.wormholestack.mpring.core.io;

import cn.wormholestack.mpring.support.utils.Assert;
import cn.wormholestack.mpring.support.utils.ClassUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description： DefaultResourceLoader
 * @Author MRyan
 * @Date 2021/9/12 22:21
 * @Version 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    private ClassLoader classLoader;


    public DefaultResourceLoader() {
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }


    public DefaultResourceLoader(ClassLoader classLoader) {
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