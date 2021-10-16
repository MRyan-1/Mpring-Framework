package cn.wormholestack.mpring.context.test.beans;

import cn.wormholestack.mpring.beans.factory.annotation.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description： 注解测试
 * @Author MRyan
 * @Date 2021/10/6 19:41
 * @Version 1.0
 */
@Component
public class AnnotationDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1", "MRyan");
        hashMap.put("2", "Ryan.ma");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
