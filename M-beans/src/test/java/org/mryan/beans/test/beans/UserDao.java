package org.mryan.beans.test.beans;

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

    static {
        map.put("MPring", "test");
        map.put("MPring1", "test1");
    }

    public String queryUser(String name) {
        return map.get(name);
    }
}
