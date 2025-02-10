package com.example.order.domain.port.out;

import com.example.order.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {

  Order save(Order order);

  Optional<Order> findByNit(String nit);

  List<Order> findAll();

  Optional<Order> update(Order order);
}
