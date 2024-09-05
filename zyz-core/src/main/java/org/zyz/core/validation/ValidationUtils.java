package org.zyz.core.validation;

import java.lang.reflect.Field;

/**
 * 验证工具类，使用反射机制对实体类的字段进行验证。
 * 该类处理 @NotBlank 和 @Email 注解的验证逻辑。
 */
public class ValidationUtils {

    /**
     * 对传入的对象执行字段验证。
     *
     * @param obj 需要验证的对象
     * @throws IllegalArgumentException 如果字段不符合验证规则，抛出异常
     */
    public static void validate(Object obj) throws IllegalArgumentException {
        // 获取对象的所有字段
        Field[] fields = obj.getClass().getDeclaredFields();

        // 遍历每个字段，检查是否有注解并进行验证
        for (Field field : fields) {
            field.setAccessible(true);  // 允许访问私有字段

            // 验证 @NotBlank 注解
            if (field.isAnnotationPresent(NotBlank.class)) {
                try {
                    String value = (String) field.get(obj);  // 获取字段的值
                    // 如果字段为空或全为空格，则抛出异常
                    if (value == null || value.trim().isEmpty()) {
                        throw new IllegalArgumentException(field.getAnnotation(NotBlank.class).message());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("无法访问字段：" + field.getName(), e);
                }
            }

            // 验证 @Email 注解
            if (field.isAnnotationPresent(Email.class)) {
                try {
                    String value = (String) field.get(obj);  // 获取字段的值
                    // 如果邮箱格式不符合正则表达式，则抛出异常
                    if (value != null && !value.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                        throw new IllegalArgumentException(field.getAnnotation(Email.class).message());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("无法访问字段：" + field.getName(), e);
                }
            }
        }
    }
}
