package org.zyz.core.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.zyz.core.validation.ValidationUtils;

@Aspect
@Component
public class ValidationAspect {

    // 拦截所有标记了 @Valid 注解的方法
    @Before("@annotation(org.zyz.core.validation.Valid)")
    public void validateMethodArguments(org.aspectj.lang.JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            ValidationUtils.validate(arg);  // 对每个方法参数执行验证
        }
    }
}
