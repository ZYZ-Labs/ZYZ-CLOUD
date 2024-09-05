package org.zyz.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyz.core.util.PasswordUtil;
import org.zyz.user.entity.User;
import org.zyz.user.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册新用户，并对用户的密码进行加密。
     * @param user 要注册的用户对象
     */
    public void createUser(User user) {
        // 对用户密码进行加密
        String encryptedPassword = PasswordUtil.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);  // 将加密后的密码设置到用户对象中
        userMapper.insert(user);  // 插入用户到数据库
    }

    /**
     * 更新用户信息。
     * @param user 包含更新信息的用户对象
     */
    public void updateUser(User user) {
        if (user.getPassword() != null) {
            // 如果用户更新了密码，则对密码进行加密处理
            user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        }
        userMapper.update(user);  // 更新用户信息
    }

    /**
     * 根据用户 ID 删除用户。
     * @param userId 要删除的用户 ID
     */
    public void deleteUser(Long userId) {
        userMapper.delete(userId);  // 删除用户
    }

    /**
     * 根据用户 ID 查询用户信息。
     * @param userId 用户 ID
     * @return 查询到的用户对象
     */
    public User getUserById(Long userId) {
        return userMapper.findById(userId);  // 根据用户 ID 查找用户
    }

    /**
     * 查询所有用户信息。
     * @return 用户列表
     */
    public List<User> getAllUsers() {
        return userMapper.findAll();  // 查询所有用户
    }
}
