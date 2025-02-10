package com.example.client.application.usecases;

import com.example.client.domain.model.Client;
import com.example.client.domain.port.in.GetClientUseCase;
import com.example.client.domain.port.out.ClientRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetClientUseCaseImplementation implements GetClientUseCase {

  private final ClientRepositoryPort clientRepositoryPort;

  public GetClientUseCaseImplementation(ClientRepositoryPort clientRepositoryPort) {
    this.clientRepositoryPort = clientRepositoryPort;
  }

  @Override
  public Optional<Client> getClient(String productId) {
    return clientRepositoryPort.findByNit(productId);
  }

  @Override
  public List<Client> getClients() {
    return clientRepositoryPort.findAll();
  }
}
