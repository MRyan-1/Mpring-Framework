package cn.wormholestack.mpring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： PropertyValues
 * @Author MRyan
 * @Date 2021/9/12 17:43
 * @Version 1.0
 */
public class PropertyValues  {

    private final List<PropertyValue> propertyValueList=new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
