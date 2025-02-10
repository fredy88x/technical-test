package com.example.inventory.domain.port.in;


import com.example.inventory.domain.model.Inventory;

public interface CreateInventoryUseCase {

  Inventory createInventory(Inventory inventory);
}
