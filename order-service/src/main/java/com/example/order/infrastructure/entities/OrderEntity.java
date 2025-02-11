package com.example.order.infrastructure.entities;

import com.example.order.domain.model.OrderProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String clientId;
  private BigDecimal totalAmount;
  private String status;
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<OrderProduct> orderProducts;
}
