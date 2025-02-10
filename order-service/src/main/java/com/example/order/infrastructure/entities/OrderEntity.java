package com.example.order.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "order")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEntity {

  @Id
  private String id;
  private String clientId;
  private String totalAmount;
  private String status;
}
