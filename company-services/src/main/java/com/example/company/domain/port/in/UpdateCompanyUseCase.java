package com.example.company.domain.port.in;

import com.example.company.domain.model.Company;
import java.util.Optional;

public interface UpdateCompanyUseCase {

  Optional<Company> updateCompany(String id, Company updatedCompany);
}
