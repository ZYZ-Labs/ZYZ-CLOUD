package org.zyz.user.mapper;

import org.apache.ibatis.annotations.*;
import org.zyz.user.entity.User;

import java.util.List;

/**
 * 用户 Mapper 接口，处理用户数据的增删改查操作。
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password, email, created_at, updated_at) " +
            "VALUES (#{username}, #{password}, #{email}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);  // 插入用户

    @Update("UPDATE users SET username = #{username}, password = #{password}, email = #{email}, updated_at = #{updatedAt} WHERE id = #{id}")
    void update(User user);  // 更新用户信息

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);  // 根据 ID 删除用户

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);  // 根据 ID 查询用户

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);  // 根据用户名查询用户

    @Select("SELECT * FROM users")
    List<User> findAll();  // 查询所有用户
}
