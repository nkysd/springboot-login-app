package com.example.springbootlogin.app.web;

public class LoginRequest
{
  private String email;
  private String password;

  // get email
  public String getEmail()
  {
    return email;
  }

  // set email
  public void setEmail(String email)
  {
    this.email = email;
  }

  // get password
  public String getPassword()
  {
    return password;
  }

  // set password
  public void setPassword(String password)
  {
    this.password = password;
  }
}