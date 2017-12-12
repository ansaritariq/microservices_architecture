package com.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entity.Users;
import com.auth.exception.NotFoundException;
import com.auth.repository.UsersRepository;
import com.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UsersRepository userRepository;
  
  @Override
  public Users findByUsername(String username) {
    Users user = userRepository.findByUserName(username);
    if(user == null){
      throw new NotFoundException("User not found : "+username);
    }
    return user;
  }

  @Override
  public Users findByUserId(Integer userId) {
    Users user = userRepository.findOne(userId);
    if(user == null){
      throw new NotFoundException("User not found : "+userId);
    }
    return user;
  }
}
