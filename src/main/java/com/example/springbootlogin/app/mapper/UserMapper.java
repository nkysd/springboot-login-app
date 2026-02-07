package com.example.springbootlogin.app.mapper;

import com.example.springbootlogin.app.mapper.data.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper
{
  @Insert("""
        INSERT INTO users (username, email, password)
        VALUES (#{username}, #{email}, #{password})
        """)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(User user);

  @Select("SELECT id, username, email, password FROM users WHERE id = #{id}")
  User findById(@Param("id") Long id);
}
