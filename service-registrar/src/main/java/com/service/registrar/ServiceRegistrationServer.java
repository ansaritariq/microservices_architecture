package com.service.registrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationServer {

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "service-registrar");
    SpringApplication.run(ServiceRegistrationServer.class, args);
  }
}
