package org.mryan.beans;

/**
 * @description： UserInfoService
 * @Author MRyan
 * @Date 2021/9/11 21:58
 * @Version 1.0
 */
public class UserInfoService {

    private String userName;

    public UserInfoService(String userName) {
        this.userName = userName;
    }

    public void queryUserInfo() {
        System.out.println("【queryUserInfo】");
    }

    @Override
    public String toString() {
        return "UserInfoService{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
