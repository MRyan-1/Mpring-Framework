package org.mryan.beans;

import org.mryan.factory.annotation.Component;

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
