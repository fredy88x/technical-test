package com.example.order.application.usecases;

import com.example.order.domain.model.Order;
import com.example.order.domain.port.in.UpdateOrderUseCase;
import com.example.order.domain.port.out.OrderRepositoryPort;
import java.util.Optional;

public class UpdateOrderUseCaseImplementation implements UpdateOrderUseCase {

  private final OrderRepositoryPort orderRepositoryPort;

  public UpdateOrderUseCaseImplementation(OrderRepositoryPort orderRepositoryPort) {
    this.orderRepositoryPort = orderRepositoryPort;
  }

  @Override
  public Optional<Order> updateOrder(String id, Order updatedOrder) {
    return orderRepositoryPort.update(updatedOrder);
  }
}
