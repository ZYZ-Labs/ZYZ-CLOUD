package org.zyz.core.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 基础实体类，包含常见的通用字段：id（主键），createdAt（创建时间），updatedAt（更新时间）。
 * 其他实体类可以继承该类，以便减少重复的字段定义。
 */
@Data
public class BaseEntity {

    /**
     * 主键 ID，唯一标识实体。由数据库自动生成（通常是自增字段）。
     */
    private Long id;

    /**
     * 实体的创建时间，表示该记录首次插入数据库的时间。
     * 在插入时自动生成，可以用于追踪记录的创建时间。
     */
    private LocalDateTime createdAt;

    /**
     * 实体的更新时间，表示该记录最后一次更新的时间。
     * 在记录每次更新时自动生成。
     */
    private LocalDateTime updatedAt;

    // 构造函数、getter/setter 方法由 Lombok 的 @Data 注解自动生成
}
