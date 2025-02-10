package com.example.inventory.infrastructure.config;


import com.example.inventory.application.usecases.CreateInventoryUseCaseImplementation;
import com.example.inventory.application.usecases.GetInventoryUseCaseImplementation;
import com.example.inventory.application.usecases.UpdateInventoryUseCaseImplementation;
import com.example.inventory.domain.port.in.CreateInventoryUseCase;
import com.example.inventory.domain.port.in.GetInventoryUseCase;
import com.example.inventory.domain.port.in.UpdateInventoryUseCase;
import com.example.inventory.domain.port.out.InventoryRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfiguration {

  @Bean
  public CreateInventoryUseCase createCategoryUseCase(
      InventoryRepositoryPort inventoryRepositoryPort) {
    return new CreateInventoryUseCaseImplementation(inventoryRepositoryPort);
  }

  @Bean
  public UpdateInventoryUseCase updateCategoryUseCase(
      InventoryRepositoryPort inventoryRepositoryPort) {
    return new UpdateInventoryUseCaseImplementation(inventoryRepositoryPort);
  }

  @Bean
  public GetInventoryUseCase getCategoryUseCase(InventoryRepositoryPort inventoryRepositoryPort) {
    return new GetInventoryUseCaseImplementation(inventoryRepositoryPort);
  }
}
