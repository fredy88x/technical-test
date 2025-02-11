package com.example.order.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_product")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;
    private Long productId;
    private Integer quantity;
}
