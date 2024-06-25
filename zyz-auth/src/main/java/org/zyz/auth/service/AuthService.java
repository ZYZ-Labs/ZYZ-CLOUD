package org.zyz.auth.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zyz.auth.util.JwtUtil;

@Service
public class AuthService {
    @Resource
    private JwtUtil jwtUtil;

    public String generateToken(Long userId) {
        return jwtUtil.generateToken(userId);
    }

    public Boolean verifyToken(String token) {
        return jwtUtil.validateToken(token);
    }
}
