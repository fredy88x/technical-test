package com.example.company.domain.port.in;

import com.example.company.domain.model.Company;

public interface CreateCompanyUseCase {

  Company createCompany(Company company);
}
