
package com.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan("com.gateway")
public class GatewayServer {
  public static void main(String[] args) {
    System.setProperty("spring.config.name", "gateway-server");
    SpringApplication.run(GatewayServer.class, args);
  }
}

