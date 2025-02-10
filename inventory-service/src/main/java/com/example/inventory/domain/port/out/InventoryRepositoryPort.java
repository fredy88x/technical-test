package com.example.inventory.domain.port.out;

import com.example.inventory.domain.model.Inventory;
import java.util.List;
import java.util.Optional;

public interface InventoryRepositoryPort {

  Inventory save(Inventory inventory);

  Optional<Inventory> findByNit(String nit);

  List<Inventory> findAll();

  Optional<Inventory> update(Inventory inventory);
}
