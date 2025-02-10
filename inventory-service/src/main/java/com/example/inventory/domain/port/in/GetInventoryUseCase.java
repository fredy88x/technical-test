package com.example.inventory.domain.port.in;

import com.example.inventory.domain.model.Inventory;
import java.util.List;
import java.util.Optional;

public interface GetInventoryUseCase {

  Optional<Inventory> getInventory(String categoryId);

  List<Inventory> getInventories();
}
