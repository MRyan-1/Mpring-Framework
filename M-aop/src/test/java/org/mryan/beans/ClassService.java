package org.mryan.beans;

import java.util.Random;

/**
 * @description： ClassService
 * @Author MRyan
 * @Date 2021/9/20 19:59
 * @Version 1.0
 */
public class ClassService {

    private String className;

    public String getClassName() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
