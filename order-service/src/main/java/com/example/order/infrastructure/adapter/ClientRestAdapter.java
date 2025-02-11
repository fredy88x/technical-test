package com.example.order.infrastructure.adapter;

import com.example.order.domain.model.Client;
import com.example.order.domain.port.out.ClientRestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientRestAdapter implements ClientRestPort {
    private final RestTemplate restTemplate;

    @Override
    public Optional<Client> getClient(String id) {

        return Optional.empty();
    }
}
