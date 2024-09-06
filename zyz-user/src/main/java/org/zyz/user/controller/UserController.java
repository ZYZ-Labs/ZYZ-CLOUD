package org.zyz.user.controller;

import org.zyz.core.response.ResponseResult;
import org.zyz.user.entity.User;
import org.zyz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询用户详情
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseResult.success(user) : ResponseResult.failure(404, "用户未找到");
    }

    // 获取所有用户分页
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseResult<List<User>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String username) {
        List<User> users = userService.getUsers(page, size, username);
        return ResponseResult.success(users);
    }

    // 创建新用户
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseResult<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseResult.success("用户创建成功");
    }

    // 更新用户信息
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseResult<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseResult.success("用户更新成功");
    }

    // 删除用户
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseResult<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseResult.success("用户删除成功");
    }

    // 忘记密码，发送重置密码邮件
    @PostMapping("/forgot-password")
    public ResponseResult<String> forgotPassword(@RequestParam String email) {
        userService.sendResetPasswordEmail(email);
        return ResponseResult.success("重置密码邮件已发送");
    }

    // 重置密码
    @PostMapping("/reset-password")
    public ResponseResult<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        userService.resetPassword(token, newPassword);
        return ResponseResult.success("密码重置成功");
    }
}
