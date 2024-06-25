package org.zyz.auth.vo;

import lombok.Data;

/**
 * 鉴权返回
 */
@Data
public class AuthResponse {
    /**
     * token
     */
    private String token;
    public AuthResponse(String token) {
        this.token = token;
    }
}
