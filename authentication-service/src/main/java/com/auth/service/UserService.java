package com.auth.service;

import com.auth.entity.Users;

public interface UserService {
  Users findByUsernameOrMobile(String usernameOrMobile);
  Users findByUserId(Integer userId);
}
