package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Orders;
import com.order.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;
  
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Orders> createOrder(@RequestBody Orders order){
    Orders createdOrder = orderService.create(order);
    return ResponseEntity.<Orders>ok(createdOrder);
  }
  @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Orders> getOrder(@PathVariable("orderId") Integer orderId){
    Orders order = orderService.getOrder(orderId);
    return ResponseEntity.<Orders>ok(order);
  }
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Orders>> getAllOrders(){
    List<Orders> orders = orderService.getOrders();
    return ResponseEntity.<List<Orders>>ok(orders);
  }
}
