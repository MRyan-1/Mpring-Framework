package org.mryan.utils.collection;

import com.sun.istack.internal.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * @description： CollectionUtils
 * @Author MRyan
 * @Date 2021/9/11 23:33
 * @Version 1.0
 */
public abstract class CollectionUtils {

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

}
