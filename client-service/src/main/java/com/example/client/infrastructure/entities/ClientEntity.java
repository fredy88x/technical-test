package com.example.client.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "client")
@Getter
@Setter
@RequiredArgsConstructor
public class ClientEntity {

  @Id
  private String nit;
  private String name;
  private String address;
  private String numberPhone;
}
