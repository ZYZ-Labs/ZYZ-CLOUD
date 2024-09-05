package org.zyz.user.entity;

import lombok.Data;
import org.zyz.core.annotation.AutoFillCreateTime;
import org.zyz.core.annotation.AutoFillUpdateTime;
import org.zyz.core.validation.Email;
import org.zyz.core.validation.NotBlank;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;  // 系统生成

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Email
    private String email;

    // 在插入时自动填充
    @AutoFillCreateTime
    private LocalDateTime createdAt;

    // 在插入和更新时自动填充
    @AutoFillUpdateTime
    private LocalDateTime updatedAt;
}
