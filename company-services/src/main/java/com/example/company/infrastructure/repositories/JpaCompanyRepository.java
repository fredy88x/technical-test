package com.example.company.infrastructure.repositories;

import com.example.company.infrastructure.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCompanyRepository extends JpaRepository<CompanyEntity, String> {

}
