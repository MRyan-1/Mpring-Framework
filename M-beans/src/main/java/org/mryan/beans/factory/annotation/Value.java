package org.mryan.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description： 自定义注解Value
 * @Author MRyan
 * @Date 2021/10/6 18:20
 * @Version 1.0
 */
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}
