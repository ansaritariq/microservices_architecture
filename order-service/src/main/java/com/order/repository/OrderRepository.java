package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
  
}
