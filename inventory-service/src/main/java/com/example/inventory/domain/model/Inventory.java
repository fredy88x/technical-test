package com.example.inventory.domain.model;


import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Inventory {

  private String id;
  private Long companyId;
  private Long productId;
  private Integer quantity;

}
