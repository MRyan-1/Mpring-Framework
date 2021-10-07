package org.mryan.espression;

/**
 * @description： BeansException
 * @Author MRyan
 * @Date 2021/9/11 23:16
 * @Version 1.0
 */
public class BeansException extends NestedRuntimeException {


    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
