package org.mryan.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description： 用于配置作用域的自定义注解，方便通过配置Bean对象注解的时候，拿到Bean对象的作用域
 * @Author MRyan
 * @Date 2021/9/25 20:07
 * @Version 1.0
 */
@Target({ElementType.TYPE,
        ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}