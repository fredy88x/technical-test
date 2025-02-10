package com.example.company.infrastructure.repositories;

import com.example.company.domain.model.Company;
import com.example.company.domain.port.out.CompanyRepositoryPort;
import com.example.company.infrastructure.entities.CompanyEntity;
import com.example.company.infrastructure.mapper.CompanyMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CompanyRepositoryAdapter implements CompanyRepositoryPort {

  private final JpaCompanyRepository jpaCompanyRepository;

  public CompanyRepositoryAdapter(JpaCompanyRepository jpaCompanyRepository) {
    this.jpaCompanyRepository = jpaCompanyRepository;
  }


  @Override
  public Company save(Company company) {
    CompanyEntity companyEntity = CompanyMapper.INSTANCE.companyToCompanyEntity(company);
    CompanyEntity companySaved = jpaCompanyRepository.save(companyEntity);
    return CompanyMapper.INSTANCE.companyEntityToCompany(companySaved);
  }

  @Override
  public Optional<Company> findByNit(String nit) {
    return jpaCompanyRepository.findById(nit).map(CompanyMapper.INSTANCE::companyEntityToCompany);
  }

  @Override
  public List<Company> findAll() {
    return jpaCompanyRepository.findAll().stream()
        .map(CompanyMapper.INSTANCE::companyEntityToCompany).toList();
  }

  @Override
  public Optional<Company> update(Company company) {
    return Optional.ofNullable(company)
        .filter(element -> jpaCompanyRepository.existsById(company.getNit()))
        .map(CompanyMapper.INSTANCE::companyToCompanyEntity)
        .map(jpaCompanyRepository::save)
        .map(CompanyMapper.INSTANCE::companyEntityToCompany);
  }
}
