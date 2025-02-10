package com.example.order.domain.port.in;

import com.example.order.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface GetOrderUseCase {

  Optional<Order> getOrder(String orderId);

  List<Order> getOrders();
}
