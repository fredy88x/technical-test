package com.example.order.application.usecases;


import com.example.order.domain.model.Order;
import com.example.order.domain.port.in.CreateOrderUseCase;
import com.example.order.domain.port.out.OrderRepositoryPort;

public class CreateOrderUseCaseImplementation implements CreateOrderUseCase {

  private final OrderRepositoryPort orderRepositoryPort;

  public CreateOrderUseCaseImplementation(OrderRepositoryPort orderRepositoryPort) {
    this.orderRepositoryPort = orderRepositoryPort;
  }

  @Override
  public Order createOrder(Order order) {
    return orderRepositoryPort.save(order);
  }
}
