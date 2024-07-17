package org.zyz.auth.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyz.auth.dto.RequestTokenDto;
import org.zyz.auth.dto.VerifyTokenDto;
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
     * @param requestTokenDto
     * @return
     */
    @PostMapping("/token")
    public ResultVo<AuthResponse> generateToken(@RequestBody RequestTokenDto requestTokenDto){
        String token = authService.generateToken(requestTokenDto.getUserId());
        return ResultVo.OK(new AuthResponse(token));
    }

    /**
     * 验证token
     * @param verifyTokenDto
     * @return
     */
    @PostMapping("/verify")
    public ResultVo<Boolean> verifyToken(@RequestBody VerifyTokenDto verifyTokenDto){
        return ResultVo.OK(authService.verifyToken(verifyTokenDto.getToken()));
    }
}
