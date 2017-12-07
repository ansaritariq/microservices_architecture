package com.auth.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth.server.AuthenticationServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticationServer.class, webEnvironment = WebEnvironment.DEFINED_PORT,
    properties = {"eureka.client.register-with-eureka:false", "eureka.client.fetch-registry:false"})
public class AuthenticationServerTest {

  @Autowired
  private TestRestTemplate restTemplate;
  @Value("${local.server.port}")
  private int port;

  @Test
  public void endPointProtectionTest() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("http://localhost:" + port + "/auth-api/users", String.class);
    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
  }
  
}
