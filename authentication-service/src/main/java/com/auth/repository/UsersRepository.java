package com.auth.repository;

import com.auth.entity.Users;

public interface UsersRepository extends BaseRepository<Users, Integer>{
  Users findByUserName(String username);
}
