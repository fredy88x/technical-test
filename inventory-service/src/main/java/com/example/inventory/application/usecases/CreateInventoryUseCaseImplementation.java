package com.example.inventory.application.usecases;


import com.example.inventory.domain.model.Inventory;
import com.example.inventory.domain.port.in.CreateInventoryUseCase;
import com.example.inventory.domain.port.out.InventoryRepositoryPort;

public class CreateInventoryUseCaseImplementation implements CreateInventoryUseCase {

  private final InventoryRepositoryPort inventoryRepositoryPort;

  public CreateInventoryUseCaseImplementation(InventoryRepositoryPort inventoryRepositoryPort) {
    this.inventoryRepositoryPort = inventoryRepositoryPort;
  }

  @Override
  public Inventory createInventory(Inventory inventory) {
    return inventoryRepositoryPort.save(inventory);
  }
}
