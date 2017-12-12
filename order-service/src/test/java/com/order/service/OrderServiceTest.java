package com.order.service;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.order.entity.Orders;
import com.order.repository.OrderRepository;
import com.order.service.impl.OrderServiceImpl;

public class OrderServiceTest {
  
  @Mock
  private OrderRepository orderRepository;
  
  @InjectMocks
  private OrderServiceImpl orderService;
  
  @Before
  public void setup(){
    initMocks(this);
  }
  @Test
  public void createOrder(){
    Orders order = getOrder(1);
    orderService.create(order);
    verify(orderRepository, times(1)).saveAndFlush(order);
  }
  @Test
  public void findOrder(){
    Orders order = getOrder(1);
    when(orderService.getOrder(order.getId())).thenReturn(order);
    
    Orders foundOrder = orderService.getOrder(order.getId());
    Assert.assertEquals("Order", order, foundOrder);
  }
  @Test
  public void getAllOrders(){
    Orders order1 = getOrder(1);
    Orders order2 = getOrder(2);

    List<Orders> orders = new ArrayList<>();
    orders.add(order1);
    orders.add(order2);
    
    when(orderService.getOrders()).thenReturn(orders);
    
    List<Orders> foundOrders = orderService.getOrders();
    Assert.assertEquals(orders.size(), foundOrders.size(), 0);
  }
  private Orders getOrder(int id){
    Orders order = new Orders();
    order.setId(id);
    order.setDate(new Date());
    order.setAmount(2000.00);
    order.setQuantity(1);
    order.setStatus("CONFIRMED");
    return order;
  }
}
