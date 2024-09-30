package com.lrium.anno;

import com.lrium.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented //元注解
//元注解
@Target({ElementType.FIELD,})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {StateValidation.class}//指定提供校验规则的类
)
public @interface State {

    String message() default "State参数错误";
    //指定分组
    Class<?>[] groups() default {};
    //负载，获取State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
