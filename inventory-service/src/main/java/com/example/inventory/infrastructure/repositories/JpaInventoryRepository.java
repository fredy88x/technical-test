package com.example.inventory.infrastructure.repositories;

import com.example.inventory.infrastructure.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInventoryRepository extends JpaRepository<InventoryEntity, String> {

}
