package com.order.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{

  private static final long serialVersionUID = 5963825246334931686L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @Column(name= "amount", nullable =false)
  private double amount;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date", nullable = false)
  private Date date;
  
  @Column(name = "status", nullable = false)
  private String status;
  
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

}
