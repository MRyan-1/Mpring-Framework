package org.mryan.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import org.mryan.BeansException;
import org.mryan.PropertyValue;
import org.mryan.PropertyValues;
import org.mryan.config.AutowireCapableBeanFactory;
import org.mryan.config.BeanReference;
import org.mryan.factory.aware.BeanClassLoaderAware;
import org.mryan.factory.aware.BeanFactoryAware;
import org.mryan.factory.aware.BeanNameAware;
import org.mryan.support.Aware;
import org.mryan.support.CglibSubclassingInstantiationStrategy;
import org.mryan.support.DisposableBeanAdapter;
import org.mryan.support.InstantiationStrategy;
import org.mryan.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description： AbstractAutowireCapableBeanFactory
 * @Author MRyan
 * @Date 2021/9/11 23:40
 * @Version 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    /**
     * 实例化策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object... args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(bd, beanName, args);
            //Bean属性填充
            applyPropertyValues(beanName, bean, bd);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, bd);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //注册有销毁方法的bean对象
        registerDisposableBeanIfNecessary(beanName, bean, bd);

        registerSingleton(beanName, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition bd, String beanName, Object... args) {
        Constructor<?> constructor = null;
        Class<?> beanClass = bd.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(bd, beanName, constructor, args);
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition bd) throws Exception {
        //1. invokeAwareMethods
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                ((BeanClassLoaderAware) bean).setBeanClassLoader(bd.getBeanClass().getClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }
        //2. 执行 BeanPostProcessor Before处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        //3. 执行Bean的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, bd);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }
        //4. 执行 BeanPostProcessor After处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    /**
     * 执行Bean的初始化方法
     *
     * @param beanName
     * @param wrappedBean
     * @param bd
     */
    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition bd) throws Exception {
        if (wrappedBean instanceof InitializingBean) {
            ((InitializingBean) wrappedBean).afterPropertiesSet();
        }
        String initMethodName = bd.getInitMethodName();
        if (!StringUtils.isEmpty(initMethodName)) {
            Method initMethod = ClassUtil.getPublicMethod(bd.getBeanClass(), initMethodName);
            if (initMethod == null) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(wrappedBean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    /**
     * Bean属性填充
     *
     * @param beanName
     * @param bean
     * @param bd
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition bd) {
        try {
            PropertyValues propertyValues = bd.getPropertyValues();
            if (propertyValues != null) {
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    String name = propertyValue.getName();
                    Object value = propertyValue.getValue();
                    //如果是BeanReference则需要递归获取Bean实例并调用getBean方法  类似A依赖B  则获取B的实例化
                    if (value instanceof BeanReference) {
                        BeanReference beanReference = (BeanReference) value;
                        //递归循环创建Bean
                        value = getBean(beanReference.getBeanName());
                    }
                    //属性填充
                    BeanUtil.setFieldValue(bean, name, value);
                }
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    /**
     * 注册有销毁方法的bean 如果bean继承DisposableBean接口或者有自定义的销毁方法
     *
     * @param beanName
     * @param bean
     * @param bd
     */
    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition bd) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(bd.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, bd));
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
