package com.example.client.domain.port.in;

import com.example.client.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface GetClientUseCase {

  Optional<Client> getClient(String clientId);

  List<Client> getClients();
}
