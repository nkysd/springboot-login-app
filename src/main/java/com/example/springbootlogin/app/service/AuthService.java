package com.example.springbootlogin.app.service;

import com.example.springbootlogin.app.mapper.UserMapper;
import com.example.springbootlogin.app.mapper.data.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
  private final UserMapper userMapper;

  // Inject mapper
  public AuthService(UserMapper userMapper)
  {
    this.userMapper = userMapper;
  }

  // Check login information
  public boolean authenticate(String email, String password)
  {
    // Find user by email
    User user = userMapper.findByEmail(email);

    // If user not found
    if (user == null)
    {
      return false;
    }

    // Compare plain password
    return password.equals(user.getPassword());
  }
}