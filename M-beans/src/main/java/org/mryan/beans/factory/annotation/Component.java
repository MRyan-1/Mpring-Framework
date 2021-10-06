package org.mryan.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description： 自定义注解Component，用于配置到Class类上的
 * @Author MRyan
 * @Date 2021/9/25 20:08
 * @Version 1.0
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}