package com.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.entity.Orders;
import com.order.service.OrderService;
import com.order.starter.OrderServiceStarter;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceStarter.class)
@WebAppConfiguration
public class OrderControllerTest {
  
  private ObjectMapper objectMapper = new ObjectMapper();
  
  @InjectMocks
  private OrderController orderController;
  
  @Mock
  private OrderService orderService;
  
  private MockMvc mockMvc;
  
  @Before
  public void setUp(){
    initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
  }
  @Test
  public void createOrder() throws Exception{
    Orders order = getOrder();
    
    String jsonValue = objectMapper.writeValueAsString(order);
    
    mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(jsonValue))
    .andExpect(status().isOk());
  }
  @Test
  public void getOrders() throws Exception{
    Orders order1 = getOrder();
    Orders order2 = getOrder();
    
    List<Orders> orders = new ArrayList<>();
    orders.add(order1);
    orders.add(order2);
    
    when(orderService.getOrders()).thenReturn(orders);
  
    mockMvc.perform(get("/orders")).andExpect(jsonPath("$[0].amount").value(orders.get(0).getAmount()))
    .andExpect(status().isOk());
  }
  private Orders getOrder(){
    Orders order = new Orders();
    order.setDate(new Date());
    order.setAmount(2000.00);
    order.setQuantity(1);
    order.setStatus("CONFIRMED");
    return order;
  }
}
