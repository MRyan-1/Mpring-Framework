package org.mryan.context.test.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @description： UserDao
 * @Author MRyan
 * @Date 2021/9/12 18:45
 * @Version 1.0
 */
public class UserDao {

    private static Map<String, String> map = new HashMap<>();


    public String queryUser(String name) {
        return map.get(name);
    }

    public void destroyMethod() {
        System.out.println("执行 destroy-method");
        map.clear();
    }

    public void initMethod() {
        System.out.println("执行 init-method");
        map.put("MPring", "test");
        map.put("MPring1", "test1");
    }
}
