package cn.wormholestack.mpring.context.test.beans;

import cn.wormholestack.mpring.beans.factory.annotation.Component;

/**
 * @description： ClassService
 * @Author MRyan
 * @Date 2021/9/25 21:22
 * @Version 1.0
 */
@Component
public class ClassService {

    private String className = "T";

    public void sout() {
        System.out.println(this.className);
    }
}
