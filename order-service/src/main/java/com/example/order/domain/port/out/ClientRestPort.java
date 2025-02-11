package com.example.order.domain.port.out;

import com.example.order.domain.model.Client;

import java.util.Optional;

public interface ClientRestPort {
    Optional<Client> getClient(String id);
}
