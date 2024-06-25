package org.zyz.auth.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyz.auth.service.AuthService;
import org.zyz.auth.vo.AuthResponse;
import org.zyz.core.vo.ResultVo;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    /**
     * 获取token
     * @param userId
     * @return
     */
    @PostMapping("/token")
    public ResultVo<AuthResponse> generateToken(@RequestBody Long userId){
        String token = authService.generateToken(userId);
        return ResultVo.OK(new AuthResponse(token));
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @PostMapping("/verify")
    public ResultVo<Boolean> verifyToken(@RequestBody String token){
        return ResultVo.OK(authService.verifyToken(token));
    }
}
