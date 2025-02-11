package com.example.product.domain.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {

  private String code;
  private String name;
  private String attributes;
  private BigDecimal price;
  private Set<Category> categories;
  private String company;

}
