package com.example.company.application.usecases;

import com.example.company.domain.model.Company;
import com.example.company.domain.port.in.GetCompanyUseCase;
import com.example.company.domain.port.out.CompanyRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetCompanyUseCaseImplementation implements GetCompanyUseCase {

  private final CompanyRepositoryPort companyRepositoryPort;

  public GetCompanyUseCaseImplementation(CompanyRepositoryPort companyRepositoryPort) {
    this.companyRepositoryPort = companyRepositoryPort;
  }

  @Override
  public Optional<Company> getCompany(String companyId) {
    return companyRepositoryPort.findByNit(companyId);
  }

  @Override
  public List<Company> getCompanies() {
    return companyRepositoryPort.findAll();
  }
}
