package com.example.order.application.usecases;


import com.example.order.domain.model.Order;
import com.example.order.domain.port.in.GetOrderUseCase;
import com.example.order.domain.port.out.OrderRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetOrderUseCaseImplementation implements GetOrderUseCase {

  private final OrderRepositoryPort orderRepositoryPort;

  public GetOrderUseCaseImplementation(OrderRepositoryPort orderRepositoryPort) {
    this.orderRepositoryPort = orderRepositoryPort;
  }

  @Override
  public Optional<Order> getOrder(String OrderId) {
    return orderRepositoryPort.findByNit(OrderId);
  }

  @Override
  public List<Order> getOrders() {
    return orderRepositoryPort.findAll();
  }
}
