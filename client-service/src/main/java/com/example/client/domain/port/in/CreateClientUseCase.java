package com.example.client.domain.port.in;

import com.example.client.domain.model.Client;

public interface CreateClientUseCase {

  Client createClient(Client client);
}
