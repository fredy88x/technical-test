package com.example.company.application.usecases;

import com.example.company.domain.model.Company;
import com.example.company.domain.port.in.UpdateCompanyUseCase;
import com.example.company.domain.port.out.CompanyRepositoryPort;
import java.util.Optional;

public class UpdateCompanyUseCaseImplementation implements UpdateCompanyUseCase {

  private final CompanyRepositoryPort companyRepositoryPort;

  public UpdateCompanyUseCaseImplementation(CompanyRepositoryPort companyRepositoryPort) {
    this.companyRepositoryPort = companyRepositoryPort;
  }

  @Override
  public Optional<Company> updateCompany(String id, Company updatedCompany) {
    return companyRepositoryPort.update(updatedCompany);
  }
}
