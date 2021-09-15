package org.mryan.beans;

import org.mryan.factory.DisposableBean;
import org.mryan.factory.InitializingBean;

/**
 * @description： UserService
 * @Author MRyan
 * @Date 2021/9/12 18:46
 * @Version 1.0
 */
public class UserService implements InitializingBean, DisposableBean {

    private String name;

    private UserDao userDao;

    public void queryUser() {
        System.out.println("查询用户信息:" + userDao.queryUser(name));
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
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }
}
