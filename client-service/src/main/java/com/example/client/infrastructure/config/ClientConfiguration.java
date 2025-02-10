package com.example.client.infrastructure.config;

import com.example.client.application.usecases.CreateClientUseCaseImplementation;
import com.example.client.application.usecases.GetClientUseCaseImplementation;
import com.example.client.application.usecases.UpdateClientUseCaseImplementation;
import com.example.client.domain.port.in.CreateClientUseCase;
import com.example.client.domain.port.in.GetClientUseCase;
import com.example.client.domain.port.in.UpdateClientUseCase;
import com.example.client.domain.port.out.ClientRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

  @Bean
  public CreateClientUseCase createProductUseCase(ClientRepositoryPort clientRepositoryPort) {
    return new CreateClientUseCaseImplementation(clientRepositoryPort);
  }

  @Bean
  public UpdateClientUseCase updateProductUseCase(ClientRepositoryPort clientRepositoryPort) {
    return new UpdateClientUseCaseImplementation(clientRepositoryPort);
  }

  @Bean
  public GetClientUseCase getProductUseCase(ClientRepositoryPort clientRepositoryPort) {
    return new GetClientUseCaseImplementation(clientRepositoryPort);
  }
}
