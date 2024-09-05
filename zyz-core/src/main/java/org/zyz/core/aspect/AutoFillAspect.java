package org.zyz.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.zyz.core.annotation.AutoFillCreateTime;
import org.zyz.core.annotation.AutoFillUpdateTime;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * 通用的自动填充切面，用于在插入和更新操作时自动填充时间字段。
 * 该切面适用于所有实体类，而不仅限于 user 模块。
 */
@Aspect
@Component
public class AutoFillAspect {

    @Before("execution(* org.zyz.*.mapper.*.insert(..)) || execution(* org.zyz.*.mapper.*.update(..))")
    public void autoFillTime(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();  // 获取方法的参数

        for (Object arg : args) {
            // 获取实体类的所有字段
            Field[] fields = arg.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);  // 允许访问私有字段

                try {
                    // 自动填充创建时间：仅在插入时生效
                    if (field.isAnnotationPresent(AutoFillCreateTime.class)) {
                        if (field.get(arg) == null) {
                            field.set(arg, LocalDateTime.now());
                        }
                    }

                    // 自动填充更新时间：插入和更新时都生效
                    if (field.isAnnotationPresent(AutoFillUpdateTime.class)) {
                        field.set(arg, LocalDateTime.now());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("无法自动填充字段：" + field.getName(), e);
                }
            }
        }
    }
}
