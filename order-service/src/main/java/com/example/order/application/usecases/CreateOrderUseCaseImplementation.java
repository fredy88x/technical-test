package com.example.order.application.usecases;


import com.example.order.domain.model.Client;
import com.example.order.domain.model.Order;
import com.example.order.domain.port.in.CreateOrderUseCase;
import com.example.order.domain.port.out.ClientRestPort;
import com.example.order.domain.port.out.OrderRepositoryPort;

import java.util.Optional;

public class CreateOrderUseCaseImplementation implements CreateOrderUseCase {

  private final OrderRepositoryPort orderRepositoryPort;
  private final ClientRestPort clientRestPort;

  public CreateOrderUseCaseImplementation(OrderRepositoryPort orderRepositoryPort, ClientRestPort clientRestPort) {
    this.orderRepositoryPort = orderRepositoryPort;
      this.clientRestPort = clientRestPort;
  }

  @Override
  public Order createOrder(Order order) {
    Optional<Client> client = clientRestPort.getClient(order.getClientId());
    if(client.isEmpty()){
      return order;
    }
    return orderRepositoryPort.save(order);
  }
}
