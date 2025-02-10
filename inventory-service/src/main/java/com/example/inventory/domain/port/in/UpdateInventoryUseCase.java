package com.example.inventory.domain.port.in;

import com.example.inventory.domain.model.Inventory;
import java.util.Optional;

public interface UpdateInventoryUseCase {

  Optional<Inventory> updateInventory(String id, Inventory updatedInventory);
}
