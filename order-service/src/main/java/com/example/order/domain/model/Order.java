package com.example.order.domain.model;


import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order {

  private String id;
  private String clientId;
  private BigDecimal totalAmount;
  private String status;
  private Set<OrderProduct> orderProducts;

}
