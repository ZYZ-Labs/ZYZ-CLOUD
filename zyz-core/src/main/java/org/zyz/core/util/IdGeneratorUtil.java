package org.zyz.core.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.lang.Snowflake;

/**
 * 分布式 ID 生成工具类，使用 Hutool 提供的 Snowflake 实现。
 */
public class IdGeneratorUtil {

    // 通过 Hutool 提供的 IdUtil 创建 Snowflake 实例
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    /**
     * 生成唯一的分布式 ID。
     *
     * @return 返回唯一的 64 位长整型 ID
     */
    public static long generateId() {
        return snowflake.nextId();
    }

    /**
     * 生成唯一的分布式 ID，并返回字符串类型。
     *
     * @return 返回唯一的字符串类型的 ID
     */
    public static String generateIdStr() {
        return snowflake.nextIdStr();
    }
}
