package org.zyz.user.mapper;

import org.apache.ibatis.annotations.*;
import org.zyz.user.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password, email, created_at, updated_at) " +
            "VALUES (#{username}, #{password}, #{email}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE users SET username = #{username}, password = #{password}, email = #{email}, updated_at = #{updatedAt} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail(String email);

    @Select("SELECT * FROM users WHERE username LIKE CONCAT('%', #{username}, '%') LIMIT #{page}, #{size}")
    List<User> findUsersByPageAndUsername(int page, int size, String username);
}
