package com.auth.service;

import com.auth.entity.Users;

public interface UserService {
  Users findByUsername(String username);
  Users findByUserId(Integer userId);
}
