package com.example.category.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryEntity {

  @Id
  private String nit;
  private String name;
  private String address;
  private String numberPhone;
}
