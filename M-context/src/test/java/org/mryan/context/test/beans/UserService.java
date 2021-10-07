package org.mryan.context.test.beans;

import org.mryan.context.ApplicationContext;
import org.mryan.espression.BeansException;
import org.mryan.context.aware.ApplicationContextAware;
import org.mryan.beans.factory.BeanFactory;
import org.mryan.beans.support.DisposableBean;
import org.mryan.beans.factory.InitializingBean;
import org.mryan.beans.factory.aware.BeanClassLoaderAware;
import org.mryan.beans.factory.aware.BeanFactoryAware;
import org.mryan.beans.factory.aware.BeanNameAware;

/**
 * @description： UserService
 * @Author MRyan
 * @Date 2021/9/12 18:46
 * @Version 1.0
 */
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String name;

    private UserDao userDao;

    public void queryUser() {
        System.out.println("【查询用户信息】:" + userDao.queryUser(name));
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【执行：UserService.destroy】");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【执行：UserService.afterPropertiesSet】");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) throws BeansException {
        System.out.println("【ClassLoader】:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactory】:" + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) throws BeansException {
        System.out.println("【BeanName】:" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【ApplicationContext:】" + applicationContext);
    }
}
