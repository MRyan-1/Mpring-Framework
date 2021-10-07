package org.mryan.aop.test.service;

/**
 * @description： ClassService
 * @Author MRyan
 * @Date 2021/9/20 19:59
 * @Version 1.0
 */
public class ClassService implements IClassService {

    private String className;

    @Override
    public String getClassName() {
        return "Nice";
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
