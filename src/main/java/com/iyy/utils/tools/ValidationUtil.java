package com.iyy.utils.tools;

import org.hibernate.validator.HibernateValidator;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

/**
 * 接口入参数据校验工具类 {@link HibernateValidator}
 *
 * @see Validator
 * @author wj
 * @since 2019/02/22
 */
public class ValidationUtil {

    /**
     * 开启快速结束模式 failFast (true)
     */
    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 校验单一对象
     * @param bean 校验对象
     */
    public static <T>  void validateBean(T bean) {
        Set<ConstraintViolation<T>> validate = validator.validate(bean);
        if (!CollectionUtils.isEmpty(validate)) {
            throw new IllegalArgumentException("参数异常: " + validate.iterator().next().getMessage());
        }
    }

    /**
     * 校验集合
     * @param collection 校验集合
     */
    public static <T> void validateCollection(Collection<T> collection) {
        for (T t : collection) {
            validateBean(t);
        }
    }

}
