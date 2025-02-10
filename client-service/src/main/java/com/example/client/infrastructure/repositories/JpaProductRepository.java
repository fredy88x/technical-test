package com.example.client.infrastructure.repositories;

import com.example.client.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ClientEntity, String> {

}
