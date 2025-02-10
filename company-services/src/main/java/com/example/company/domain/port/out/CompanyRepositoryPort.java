package com.example.company.domain.port.out;

import com.example.company.domain.model.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryPort {

  Company save(Company company);

  Optional<Company> findByNit(String nit);

  List<Company> findAll();

  Optional<Company> update(Company company);
}
