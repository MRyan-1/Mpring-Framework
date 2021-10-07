package org.mryan.espression;

import com.sun.istack.internal.Nullable;

import java.io.IOException;

/**
 * @description： NestedIOException
 * @Author MRyan
 * @Date 2021/9/12 21:50
 * @Version 1.0
 */
public class NestedIOException extends IOException {

    static {
        NestedExceptionUtils.class.getName();
    }

    public NestedIOException(String msg) {
        super(msg);
    }

    public NestedIOException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }

    @Override
    @Nullable
    public String getMessage() {
        return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
    }
}
