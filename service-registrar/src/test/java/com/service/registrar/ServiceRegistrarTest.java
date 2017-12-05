package com.service.registrar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest({"server.port:8761", "eureka.client.register-with-eureka:false",
    "eureka.client.fetch-registry:false"})
public class ServiceRegistrarTest {

  @Test
  public void contextLoadTest() {

  }
}
