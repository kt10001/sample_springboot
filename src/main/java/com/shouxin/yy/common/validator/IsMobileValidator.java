package com.shouxin.yy.common.validator;

import cn.hutool.core.lang.Validator;
import com.shouxin.yy.utils.RegexUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @time 2023/4/17 9:14 下午
 * @Author feikong
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile isMobile) {
        required = isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return RegexUtil.isMobile(value);
        }
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return RegexUtil.isMobile(value);
    }
}
