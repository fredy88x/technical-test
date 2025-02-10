package com.example.client.domain.port.out;

import com.example.client.domain.model.Order;

import java.util.List;

public interface OrderClientServicePort {
    List<Order> getOrdersByClient(String clientId);
}
