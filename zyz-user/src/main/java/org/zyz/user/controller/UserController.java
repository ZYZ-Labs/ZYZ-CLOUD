package org.zyz.user.controller;

import org.zyz.core.response.ResponseResult;
import org.zyz.core.validation.Valid;
import org.zyz.user.entity.User;
import org.zyz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据 ID 查询用户信息。
     */
    @GetMapping("/{id}")
    public ResponseResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseResult.success(user); // 成功返回用户数据
        } else {
            // 业务逻辑中的失败，返回 404 状态码和自定义的错误信息
            return ResponseResult.failure(404, "用户未找到");
        }
    }

    /**
     * 查询所有用户信息。
     */
    @GetMapping("/all")
    public ResponseResult<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseResult.success(users);
    }

    /**
     * 创建新用户。
     */
    @PostMapping("/create")
    @Valid  // 启用自定义验证
    public ResponseResult<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseResult.success("用户创建成功");
    }

    /**
     * 更新用户信息。
     */
    @PutMapping("/update")
    @Valid  // 启用自定义验证
    public ResponseResult<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseResult.success("用户更新成功");
    }

    /**
     * 根据 ID 删除用户。
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseResult.success("用户删除成功");
    }
}
