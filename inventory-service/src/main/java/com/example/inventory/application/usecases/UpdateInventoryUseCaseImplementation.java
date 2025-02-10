package com.example.inventory.application.usecases;


import com.example.inventory.domain.model.Inventory;
import com.example.inventory.domain.port.in.UpdateInventoryUseCase;
import com.example.inventory.domain.port.out.InventoryRepositoryPort;
import java.util.Optional;

public class UpdateInventoryUseCaseImplementation implements UpdateInventoryUseCase {

  private final InventoryRepositoryPort inventoryRepositoryPort;

  public UpdateInventoryUseCaseImplementation(InventoryRepositoryPort inventoryRepositoryPort) {
    this.inventoryRepositoryPort = inventoryRepositoryPort;
  }

  @Override
  public Optional<Inventory> updateInventory(String id, Inventory updatedInventory) {
    return inventoryRepositoryPort.update(updatedInventory);
  }
}
