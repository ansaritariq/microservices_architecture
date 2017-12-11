package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Orders;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
  
  @Autowired
  private OrderRepository orderRepository;
  
  @Override
  public Orders create(Orders order) {
    return orderRepository.saveAndFlush(order);
  }

  @Override
  public List<Orders> getOrders() {
   return orderRepository.findAll();
  }

  @Override
  public Orders getOrder(Integer id) {
    return orderRepository.findOne(id);
  }

}
