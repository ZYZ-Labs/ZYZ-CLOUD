package org.zyz.gateway.controller;

// 引入Spring的Web控制器注解
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用 @RestController 注解，表示这是一个Spring的控制器类
@RestController
public class HealthController {

    /**
     * 创建一个简单的健康检查接口.
     * 该接口会返回服务的健康状态。
     * 通过访问 /health 路径，可以判断服务是否正常运行。
     *
     * @return 返回 "OK"，表示服务是健康的。
     */
    @GetMapping("/health")
    public String health() {
        // 可以扩展逻辑以检查其他服务依赖
        return "OK";
    }
}
