package com.order.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@ComponentScan("com.order")
@EnableJpaRepositories(basePackages ={"com.order.repository"})
@EntityScan(basePackages={"com.order.entity"})
public class OrderServiceStarter {
  public static void main(String[] args) {
    SpringApplication.run(OrderServiceStarter.class, args);
  }
}
