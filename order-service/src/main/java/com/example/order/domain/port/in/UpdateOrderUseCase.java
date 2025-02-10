package com.example.order.domain.port.in;

import com.example.order.domain.model.Order;
import java.util.Optional;

public interface UpdateOrderUseCase {

  Optional<Order> updateOrder(String id, Order updatedOrder);
}
