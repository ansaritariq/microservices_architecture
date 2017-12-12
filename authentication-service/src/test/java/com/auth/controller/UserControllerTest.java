package com.auth.controller;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.auth.entity.Users;
import com.auth.server.AuthenticationServer;
import com.auth.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticationServer.class)
@WebAppConfiguration
public class UserControllerTest {
  
  @InjectMocks
  private UserController userController;
  
  @Mock
  private UserService userService;
  
  private MockMvc mockMvc;
  
  @Before
  public void setup(){
    initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }
  @Test
  public void findByUsername() throws Exception{
    Users user = getUser();
    
    when(userService.findByUsername(user.getUserName())).thenReturn(user);
    
    mockMvc.perform(get("/users").principal(new Principal() {
      @Override
      public String getName() {
        return user.getUserName();
      }
    }))
    .andExpect(jsonPath("$.userName").value(user.getUserName()))
    .andExpect(status().isOk());
  }
  @Test
  public void authenticate() throws Exception{
  Users user = getUser();
    
    when(userService.findByUsername(user.getUserName())).thenReturn(user);
    mockMvc.perform(get("/users/authenticate").principal(new Principal() {
      @Override
      public String getName() {
        return user.getUserName();
      }
    }))
    .andExpect(jsonPath("$.name").value(user.getUserName()))
    .andExpect(status().isOk());
  }
  private Users getUser(){

    Users user = new Users();
    user.setUserName("nolan");
    user.setEmail("christopher@test.com");
    return user;
  }
  
}
