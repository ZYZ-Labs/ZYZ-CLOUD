package org.zyz.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyz.core.util.JwtUtil;
import org.zyz.core.util.PasswordUtil;
import org.zyz.user.entity.User;
import org.zyz.user.mapper.UserMapper;

@Service
public class UserLoginService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录操作，根据用户名和密码验证用户并生成 JWT Token。
     * @param username 用户名
     * @param password 明文密码
     * @return 成功登录时生成的 JWT Token
     */
    public String login(String username, String password) {
        // 根据用户名查找用户
        User user = userMapper.findByUsername(username);

        // 如果用户存在且密码匹配，生成并返回 JWT Token
        if (user != null && PasswordUtil.matches(password, user.getPassword())) {
            return JwtUtil.generateToken(username);  // 成功生成 JWT Token
        }
        throw new RuntimeException("用户名或密码错误");
    }

    /**
     * 验证用户 Token 的有效性，检查 Token 是否过期或无效。
     * @param token 要验证的 JWT Token
     * @return 如果 Token 有效返回 true，否则抛出异常
     */
    public boolean validateToken(String token) {
        // 检查 Token 是否已过期
        if (JwtUtil.isTokenExpired(token)) {
            throw new RuntimeException("Token 已过期");
        }
        return true;  // Token 有效
    }
}
