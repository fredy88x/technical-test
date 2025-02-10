package com.example.client.application.usecases;

import com.example.client.domain.model.Client;
import com.example.client.domain.port.in.UpdateClientUseCase;
import com.example.client.domain.port.out.ClientRepositoryPort;
import java.util.Optional;

public class UpdateClientUseCaseImplementation implements UpdateClientUseCase {

  private final ClientRepositoryPort clientRepositoryPort;

  public UpdateClientUseCaseImplementation(ClientRepositoryPort clientRepositoryPort) {
    this.clientRepositoryPort = clientRepositoryPort;
  }

  @Override
  public Optional<Client> updateClient(String id, Client updatedClient) {
    return clientRepositoryPort.update(updatedClient);
  }
}
