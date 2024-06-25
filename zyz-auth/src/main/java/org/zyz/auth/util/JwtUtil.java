package org.zyz.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String secretKey = "";
    /**
     * 超时时间
     */
    private final Long TIMEOUT = 24 * 60 * 60L;

    /**
     * 生成token
     *
     * @param userId
     * @return
     */
    public String generateToken(Long userId) {
        Claims claims = Jwts.claims().setSubject(userId.toString());
        Date now = new Date();
        Date validity = new Date(now.getTime() + TIMEOUT);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
