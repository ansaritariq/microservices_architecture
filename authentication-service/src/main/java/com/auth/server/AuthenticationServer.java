package com.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.auth")
@EnableJpaRepositories(basePackages ={"com.auth.repository"})
@EntityScan(basePackages={"com.auth.entity"})
public class AuthenticationServer {

  public static void main(String[] args) {
    SpringApplication.run(AuthenticationServer.class, args);
  }
}
