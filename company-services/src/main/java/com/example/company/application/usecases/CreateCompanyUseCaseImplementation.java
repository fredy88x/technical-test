package com.example.company.application.usecases;

import com.example.company.domain.model.Company;
import com.example.company.domain.port.in.CreateCompanyUseCase;
import com.example.company.domain.port.out.CompanyRepositoryPort;

public class CreateCompanyUseCaseImplementation implements CreateCompanyUseCase {

  private final CompanyRepositoryPort companyRepositoryPort;

  public CreateCompanyUseCaseImplementation(CompanyRepositoryPort companyRepositoryPort) {
    this.companyRepositoryPort = companyRepositoryPort;
  }

  @Override
  public Company createCompany(Company company) {
    return companyRepositoryPort.save(company);
  }
}
