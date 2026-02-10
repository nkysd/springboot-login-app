package com.example.springbootlogin.app.controller;

import com.example.springbootlogin.app.service.AuthService;
import com.example.springbootlogin.app.web.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginApiController
{
  private final AuthService authService;

  // inject service
  public LoginApiController(AuthService authService)
  {
    this.authService = authService;
  }

  /**
   * Login API
   * Called from login.js using fetch()
   */
  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(
      @RequestBody LoginRequest request,
      HttpSession session)
  {
    boolean success = authService.authenticate(
        request.getEmail(),
        request.getPassword()
    );

    // login failed
    if (!success)
    {
      return ResponseEntity
          .status(401)
          .body(Map.of("message", "Invalid email or password"));
    }

    // save login info in session
    session.setAttribute("LOGIN_EMAIL", request.getEmail());

    // login success
    return ResponseEntity.ok(Map.of("message", "ok"));
  }
}