package com.example.company.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "company")
@Getter
@Setter
@RequiredArgsConstructor
public class CompanyEntity {

  @Id
  private String nit;
  private String name;
  private String address;
  private String numberPhone;
}
