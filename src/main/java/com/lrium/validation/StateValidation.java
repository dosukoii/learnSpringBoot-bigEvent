package com.lrium.validation;

import com.lrium.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value 将来要校验的数据
     * @param constraintValidatorContext
     * @return 如果返回false，则校验不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if (value == null){
            return false;
        }
        if (value.equals("已发布")|| value.equals("草稿")){
            return true;
        }
        return false;
    }
}
