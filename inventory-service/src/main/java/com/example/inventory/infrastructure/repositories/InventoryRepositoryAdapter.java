package com.example.inventory.infrastructure.repositories;


import com.example.inventory.domain.model.Inventory;
import com.example.inventory.domain.port.out.InventoryRepositoryPort;
import com.example.inventory.infrastructure.entities.InventoryEntity;
import com.example.inventory.infrastructure.mapper.InventoryMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class InventoryRepositoryAdapter implements InventoryRepositoryPort {

  private final JpaInventoryRepository jpaInventoryRepository;

  public InventoryRepositoryAdapter(JpaInventoryRepository jpaInventoryRepository) {
    this.jpaInventoryRepository = jpaInventoryRepository;
  }


  @Override
  public Inventory save(Inventory inventory) {
    InventoryEntity inventoryEntity = InventoryMapper.INSTANCE.categoryToCategoryEntity(inventory);
    InventoryEntity categorySaved = jpaInventoryRepository.save(inventoryEntity);
    return InventoryMapper.INSTANCE.categoryEntityToCategory(categorySaved);
  }

  @Override
  public Optional<Inventory> findByNit(String nit) {
    return jpaInventoryRepository.findById(nit)
        .map(InventoryMapper.INSTANCE::categoryEntityToCategory);
  }

  @Override
  public List<Inventory> findAll() {
    return jpaInventoryRepository.findAll().stream()
        .map(InventoryMapper.INSTANCE::categoryEntityToCategory).toList();
  }

  @Override
  public Optional<Inventory> update(Inventory Inventory) {
    return Optional.ofNullable(Inventory)
        .filter(element -> jpaInventoryRepository.existsById(Inventory.getId()))
        .map(InventoryMapper.INSTANCE::categoryToCategoryEntity)
        .map(jpaInventoryRepository::save)
        .map(InventoryMapper.INSTANCE::categoryEntityToCategory);
  }
}
