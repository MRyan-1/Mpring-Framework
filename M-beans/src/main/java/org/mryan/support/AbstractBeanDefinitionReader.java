package org.mryan.support;

import org.mryan.BeansException;
import org.mryan.core.io.DefaultResourceLoader;
import org.mryan.core.io.Resource;
import org.mryan.core.io.ResourceLoader;
import org.mryan.factory.BeanDefinitionRegistry;

/**
 * @description： AbstractBeanDefinitionReader
 * @Author MRyan
 * @Date 2021/9/12 23:35
 * @Version 1.0
 */
public class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {

    }
}
