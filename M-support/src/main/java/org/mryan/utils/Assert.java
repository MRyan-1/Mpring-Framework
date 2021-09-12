package org.mryan.utils;

import com.sun.istack.internal.Nullable;


/**
 * @description： 断言
 * @Author MRyan
 * @Date 2021/9/11 23:09
 * @Version 1.0
 */
public abstract class Assert {

    /**
     * 判定不为空
     *
     * @param object
     * @param message
     */
    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(@Nullable String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }


}
