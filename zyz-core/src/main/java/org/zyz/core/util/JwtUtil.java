package org.zyz.core.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JwtUtil 工具类，提供用于生成和解析 JWT 的功能。
 * 使用 HS256 算法对 JWT 进行签名。
 */
public class JwtUtil {

    // 定义签名的密钥，确保在生产环境中使用安全的密钥
    private static final String SECRET_KEY = "mySecretKey";

    /**
     * 生成 JWT Token。
     * @param username 用户名，作为 JWT 的主体（Subject）
     * @return 生成的 JWT 字符串
     */
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // 将用户名作为 Token 的主题
                .setIssuedAt(new Date())  // 设置 Token 的生成时间
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // 设置 Token 的过期时间，1 天后失效
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // 使用 HS256 算法签名
                .compact();  // 生成并返回 JWT 字符串
    }

    /**
     * 从 JWT Token 中解析出用户名。
     * @param token JWT 字符串
     * @return 解析出的用户名
     */
    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)  // 设置用于签名验证的密钥
                .parseClaimsJws(token)  // 解析 JWT
                .getBody()
                .getSubject();  // 返回 JWT 的主题，即用户名
    }

    /**
     * 验证 JWT Token 是否过期。
     * @param token JWT 字符串
     * @return 如果过期返回 true，否则返回 false
     */
    public static boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)  // 设置用于签名验证的密钥
                .parseClaimsJws(token)  // 解析 JWT
                .getBody()
                .getExpiration()  // 获取 Token 的过期时间
                .before(new Date());  // 检查是否在当前时间之前（是否已过期）
    }
}
