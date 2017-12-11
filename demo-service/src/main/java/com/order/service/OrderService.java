package com.order.service;

import java.util.List;

import com.order.entity.Orders;

public interface OrderService {
  Orders create(Orders order);
  List<Orders> getOrders();
  Orders getOrder(Integer id);
}
