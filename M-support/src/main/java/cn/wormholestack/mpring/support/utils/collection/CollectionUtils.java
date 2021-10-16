package cn.wormholestack.mpring.support.utils.collection;

import java.util.Collection;
import java.util.Map;

/**
 * @description： CollectionUtils
 * @Author MRyan
 * @Date 2021/9/11 23:33
 * @Version 1.0
 */
public abstract class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

}
