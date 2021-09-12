package org.mryan;

/**
 * @description： Bean属性信息
 * @Author MRyan
 * @Date 2021/9/12 17:41
 * @Version 1.0
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
