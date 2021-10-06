package org.mryan.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description： 自定义注解Qualifier 与注解Autowired配合使用
 * @Author MRyan
 * @Date 2021/10/6 18:18
 * @Version 1.0
 */
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}