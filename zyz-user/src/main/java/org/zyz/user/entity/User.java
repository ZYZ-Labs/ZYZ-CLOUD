package org.zyz.user.entity;

import lombok.Data;
import org.zyz.core.annotation.AutoFillCreateTime;
import org.zyz.core.annotation.AutoFillUpdateTime;
import org.zyz.core.validation.Email;
import org.zyz.core.validation.NotBlank;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Email
    private String email;

    @AutoFillCreateTime
    private LocalDateTime createdAt;

    @AutoFillUpdateTime
    private LocalDateTime updatedAt;
}
