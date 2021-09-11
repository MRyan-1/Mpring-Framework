package org.mryan;

import com.sun.istack.internal.Nullable;

/**
 * @description： NestedRuntimeException
 * @Author MRyan
 * @Date 2021/9/11 23:18
 * @Version 1.0
 */
public abstract class NestedRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 123456789L;

    public NestedRuntimeException(String msg) {
        super(msg);
    }

    public NestedRuntimeException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }


}
