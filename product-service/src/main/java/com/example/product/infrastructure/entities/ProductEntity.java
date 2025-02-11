package com.example.product.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@RequiredArgsConstructor
public class ProductEntity {

  @Id
  private String code;
  private String name;
  private String attributes;
  private BigDecimal price;
  private String company;

  @ManyToMany
  @JoinTable(
      name = "product_category",
      joinColumns = @JoinColumn(name = "product_code"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<CategoryEntity> categories;
}
