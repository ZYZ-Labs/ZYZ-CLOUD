package org.zyz.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于自动填充创建时间的自定义注解。
 * 仅在插入操作时使用。
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFillCreateTime {
    String message() default "自动填充创建时间";
}
