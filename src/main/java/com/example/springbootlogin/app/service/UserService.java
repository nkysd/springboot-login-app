package com.example.springbootlogin.app.service;

import com.example.springbootlogin.app.mapper.UserMapper;
import com.example.springbootlogin.app.mapper.data.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
  private final UserMapper mapper;

  public UserService(UserMapper mapper)
  {
    this.mapper = mapper;
  }

  public User create(User user)
  {
    mapper.insert(user);
    return user;
  }

  public User findById(Long id)
  {
    return mapper.findById(id);
  }
}
