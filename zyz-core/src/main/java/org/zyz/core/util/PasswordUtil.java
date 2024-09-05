package org.zyz.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * PasswordUtil 工具类，提供用于密码加密和校验的功能。
 * 采用 BCrypt 算法对密码进行加密，并提供匹配原始密码和加密密码的校验方法。
 */
public class PasswordUtil {

    // 定义 BCryptPasswordEncoder 用于加密和解密密码
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 对原始密码进行加密。
     * @param rawPassword 明文密码
     * @return 加密后的密码字符串
     */
    public static String encrypt(String rawPassword) {
        return passwordEncoder.encode(rawPassword);  // 返回加密后的密码
    }

    /**
     * 校验原始密码与加密后的密码是否匹配。
     * @param rawPassword 明文密码
     * @param encodedPassword 加密后的密码
     * @return 如果匹配则返回 true，否则返回 false
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);  // 验证密码是否匹配
    }
}
