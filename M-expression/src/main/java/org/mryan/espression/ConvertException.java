package org.mryan.espression;

/**
 * @description： ConvertException
 * @Author MRyan
 * @Date 2021/9/12 18:26
 * @Version 1.0
 */
public class ConvertException extends RuntimeException {
    private static final long serialVersionUID = 4730597402855274362L;

    public ConvertException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
