package com.example.springbootlogin.app.controller;

import com.example.springbootlogin.app.mapper.data.User;
import com.example.springbootlogin.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
  private final UserService service;

  public UserController(UserService service)
  {
    this.service = service;
  }

  @PostMapping
  public User create(@RequestBody User user)
  {
    return service.create(user);
  }

  @GetMapping("/{id}")
  public User get(@PathVariable Long id)
  {
    return service.findById(id);
  }
}
