package com.lp.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anno {
    /** 要执行的操作类型比如：add操作 **/

    public String operationType() default "";
    /** 要执行的具体操作比如：生成题目 **/

    public String operationName() default "";
}
