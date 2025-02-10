package com.example.order.domain.port.in;


import com.example.order.domain.model.Order;

public interface CreateOrderUseCase {

  Order createOrder(Order order);
}
