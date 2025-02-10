package com.example.client.domain.port.out;

import com.example.client.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {

  Client save(Client client);

  Optional<Client> findByNit(String nit);

  List<Client> findAll();

  Optional<Client> update(Client client);
}
