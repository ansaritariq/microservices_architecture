package com.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.Users;
import com.auth.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @GetMapping("/authenticate")
  public ResponseEntity<Principal> user(Principal user) {
   return ResponseEntity.<Principal>ok(user);
  }
  
  @GetMapping
  public ResponseEntity<Users> getUserByUsername(Principal principal){
    Users user = userService.findByUsernameOrMobile(principal.getName());
    return ResponseEntity.<Users>ok(user);    
  }
}
