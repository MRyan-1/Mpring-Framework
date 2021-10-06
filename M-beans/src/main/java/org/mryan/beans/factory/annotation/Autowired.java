package org.mryan.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @description： 自定义注解Autowired 注入对象、注入属性 与Autowired注解配合使用
 * @Author MRyan
 * @Date 2021/10/6 18:16
 * @Version 1.0
 */
@Target({ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Autowired {
}
