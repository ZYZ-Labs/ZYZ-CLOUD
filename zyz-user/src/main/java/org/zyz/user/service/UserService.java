package org.zyz.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.zyz.core.util.PasswordUtil;
import org.zyz.user.entity.User;
import org.zyz.user.mapper.UserMapper;
import org.zyz.core.util.JwtUtil;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "userCache", key = "#id")
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    @CacheEvict(value = "userCache", key = "#user.id")
    public void updateUser(User user) {
        if (user.getPassword() != null) {
            user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        }
        userMapper.update(user);
    }

    @CacheEvict(value = "userCache", key = "#userId")
    public void deleteUser(Long userId) {
        userMapper.delete(userId);
    }

    public List<User> getUsers(int page, int size, String username) {
        // 调用分页查询
        return userMapper.findUsersByPageAndUsername(page, size, username);
    }

    public void createUser(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userMapper.insert(user);
    }

    @Async
    public void sendResetPasswordEmail(String email) {
        // 生成重置密码的 token 并发送邮件
        String token = JwtUtil.generateToken(email);
        // 通过邮件发送 token 给用户（假设已经实现了邮件发送功能）
    }

    public void resetPassword(String token, String newPassword) {
        String email = JwtUtil.getSubjectFromToken(token);
        User user = userMapper.findByEmail(email);
        if (user != null) {
            user.setPassword(PasswordUtil.encrypt(newPassword));
            userMapper.update(user);
        }
    }
}
