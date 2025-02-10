package com.example.inventory.infrastructure.mapper;

import com.example.inventory.domain.model.Inventory;
import com.example.inventory.infrastructure.entities.InventoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

  InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

  InventoryEntity categoryToCategoryEntity(Inventory inventory);

  Inventory categoryEntityToCategory(InventoryEntity inventoryEntity);
}
