package cn.wormholestack.mpring.beans.factory.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.wormholestack.mpring.beans.support.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description： ClassPathScanningCandidateComponentProvider
 * @Author MRyan
 * @Date 2021/9/25 20:08
 * @Version 1.0
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 扫描到所有 @Component 注解的 Bean 对象
     *
     * @param basePackage
     * @return
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}

