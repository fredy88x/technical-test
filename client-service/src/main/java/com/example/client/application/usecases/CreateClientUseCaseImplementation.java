package com.example.client.application.usecases;

import com.example.client.domain.model.Client;
import com.example.client.domain.port.in.CreateClientUseCase;
import com.example.client.domain.port.out.ClientRepositoryPort;

public class CreateClientUseCaseImplementation implements CreateClientUseCase {

  private final ClientRepositoryPort clientRepositoryPort;

  public CreateClientUseCaseImplementation(ClientRepositoryPort clientRepositoryPort) {
    this.clientRepositoryPort = clientRepositoryPort;
  }

  @Override
  public Client createClient(Client client) {
    return clientRepositoryPort.save(client);
  }
}
