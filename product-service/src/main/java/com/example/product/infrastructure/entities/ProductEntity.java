package com.example.product.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
@RequiredArgsConstructor
public class ProductEntity {

  @Id
  private String code;
  private String name;
  private String attributes;
  private BigDecimal price;
}
