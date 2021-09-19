package org.mryan.beans;

/**
 * @description： UserService
 * @Author MRyan
 * @Date 2021/9/12 18:46
 * @Version 1.0
 */
public class UserService {

    private String name;

    private UserDao userDao;

    public void queryUser() {
        System.out.println("【查询用户信息】:" + userDao.queryUser(name));
    }

    public String getName() {
        return name;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
