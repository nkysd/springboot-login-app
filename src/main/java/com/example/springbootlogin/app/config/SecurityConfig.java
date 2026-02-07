package com.example.springbootlogin.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
  /*
   * This configuration is added to allow access to the /users API
   * during development and testing.
   *
   * Spring Security blocks all endpoints by default, which caused
   * 401 Unauthorized errors when testing user registration.
   *
   * CSRF is disabled temporarily to allow POST requests from tools
   * like Postman.
   *
   * This configuration will be updated later when authentication
   * and authorization are fully implemented.
   */

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
  {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/users/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }
}
