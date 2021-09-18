package org.mryan.beans;

import org.mryan.factory.FactoryBean;

/**
 * @description： ProxyBeanFactory
 * @Author MRyan
 * @Date 2021/9/18 22:38
 * @Version 1.0
 */
public class ProxyBeanFactory implements FactoryBean<UserDao> {

    @Override
    public UserDao getObject() throws Exception {
        System.out.println("代理对象：ProxyBeanFactory");
        UserDao userDao = new UserDao();
        userDao.queryUser("MPring");
        return userDao;

    }

    @Override
    public Class<?> getObjectType() {
        return ProxyBeanFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
