package org.zyz.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类，用于在 Redis 中进行缓存的常见操作。
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 将数据存入 Redis 缓存，并指定过期时间。
     *
     * @param key 缓存的键
     * @param value 缓存的值
     * @param expireTime 过期时间（单位：秒）
     */
    public void set(String key, String value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 根据键从 Redis 缓存中获取值。
     *
     * @param key 缓存的键
     * @return 返回缓存中的值，如果键不存在则返回 null
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除 Redis 缓存中指定键的数据。
     *
     * @param key 缓存的键
     * @return 成功删除则返回 true，失败则返回 false
     */
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}
