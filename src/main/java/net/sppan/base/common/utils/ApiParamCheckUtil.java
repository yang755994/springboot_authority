package net.sppan.base.common.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 接口参数前置校验
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/7 15:59
 */
public class ApiParamCheckUtil {

    private static Validator validator = null;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static <T> String checkParam(T obj) {
        Set<ConstraintViolation<T>> validateSet = validator.validate(obj);
        if (validateSet != null && validateSet.size() > 0) {
            StringBuilder strBuff = new StringBuilder();
            for (ConstraintViolation<T> cv : validateSet) {
                strBuff.append(cv.getMessage()).append(";");
            }
            return strBuff.toString();
        } else {
            return null;
        }
    }
}