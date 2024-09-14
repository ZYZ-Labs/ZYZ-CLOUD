package com.zyz.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                // 禁用 CSRF（如果不需要）
                .csrf(new Customizer<ServerHttpSecurity.CsrfSpec>() {
                    @Override
                    public void customize(ServerHttpSecurity.CsrfSpec csrfSpec) {
                        csrfSpec.disable()
                                // 配置授权规则
                                .authorizeExchange(exchange -> exchange
                                        // 允许匿名访问 /health 和 /actuator/health
                                        .pathMatchers("/health", "/actuator/health").permitAll()
                                        // 其他所有请求都需要认证
                                        .anyExchange().authenticated()
                                )
                                // 配置 OAuth2 资源服务器以使用 JWT
                                .oauth2ResourceServer(oauth2 -> oauth2
                                        .jwt(Customizer.withDefaults())
                                );
                    }
                });

        return http.build();
    }
}
