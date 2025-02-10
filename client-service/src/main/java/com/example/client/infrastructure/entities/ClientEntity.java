package com.example.client.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
@RequiredArgsConstructor
public class ClientEntity {

  @Id
  private String id;
  private String nombre;
  private String correo;
}
