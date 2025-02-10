package com.example.inventory.application.usecases;

import com.example.inventory.domain.model.Inventory;
import com.example.inventory.domain.port.in.GetInventoryUseCase;
import com.example.inventory.domain.port.out.InventoryRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetInventoryUseCaseImplementation implements GetInventoryUseCase {

  private final InventoryRepositoryPort inventoryRepositoryPort;

  public GetInventoryUseCaseImplementation(InventoryRepositoryPort inventoryRepositoryPort) {
    this.inventoryRepositoryPort = inventoryRepositoryPort;
  }

  @Override
  public Optional<Inventory> getInventory(String categoryId) {
    return inventoryRepositoryPort.findByNit(categoryId);
  }

  @Override
  public List<Inventory> getInventories() {
    return inventoryRepositoryPort.findAll();
  }
}
