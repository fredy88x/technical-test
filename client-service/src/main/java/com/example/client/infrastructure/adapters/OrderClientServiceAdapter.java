package com.example.client.infrastructure.adapters;

import com.example.client.domain.model.Order;
import com.example.client.domain.port.out.OrderClientServicePort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderClientServiceAdapter implements OrderClientServicePort {

    private final RestTemplate restTemplate;

    public OrderClientServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Order> getOrdersByClient(String clientId) {
        return List.of();
    }
}
