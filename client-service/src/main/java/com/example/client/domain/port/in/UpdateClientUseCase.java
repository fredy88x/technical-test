package com.example.client.domain.port.in;

import com.example.client.domain.model.Client;
import java.util.Optional;

public interface UpdateClientUseCase {

  Optional<Client> updateClient(String id, Client updatedClient);
}
