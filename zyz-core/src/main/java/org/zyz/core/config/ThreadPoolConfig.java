package org.zyz.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 全局线程池配置，避免高并发时频繁创建线程，提升系统性能。
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);  // 核心线程数
        executor.setMaxPoolSize(50);   // 最大线程数
        executor.setQueueCapacity(100); // 任务队列的容量
        executor.setKeepAliveSeconds(300); // 空闲线程的存活时间
        executor.setThreadNamePrefix("Async-Task-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 当任务太多时的处理策略
        executor.initialize();
        return executor;
    }
}
