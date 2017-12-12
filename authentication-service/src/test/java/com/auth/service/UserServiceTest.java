package com.auth.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.auth.entity.Users;
import com.auth.repository.UsersRepository;
import com.auth.service.impl.UserServiceImpl;

public class UserServiceTest {

  @InjectMocks
  private UserServiceImpl userService;
  
  @Mock
  private UsersRepository userRepository;
  
  @Before
  public void setup(){
    initMocks(this);
  }
  @Test
  public void findByUsername(){
    Users user = getUser();
    
    when(userRepository.findByUserName(user.getUserName())).thenReturn(user);
    Users foundUser = userService.findByUsername(user.getUserName());
    Assert.assertEquals("User", user, foundUser);
  }
  @Test
  public void findByUserId(){
    Users user = getUser();
    
    when(userRepository.findOne(user.getUserId())).thenReturn(user);
    Users foundUser = userService.findByUserId(user.getUserId());
    Assert.assertEquals("User id", user, foundUser);
  }
  private Users getUser(){
    Users user = new Users();
    user.setUserId(345678);
    user.setUserName("nolan");
    user.setEmail("christopher@test.com");
    return user;
  }
}
