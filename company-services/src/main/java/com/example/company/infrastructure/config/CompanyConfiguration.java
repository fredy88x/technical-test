package com.example.company.infrastructure.config;

import com.example.company.application.usecases.CreateCompanyUseCaseImplementation;
import com.example.company.application.usecases.GetCompanyUseCaseImplementation;
import com.example.company.application.usecases.UpdateCompanyUseCaseImplementation;
import com.example.company.domain.port.in.CreateCompanyUseCase;
import com.example.company.domain.port.in.GetCompanyUseCase;
import com.example.company.domain.port.in.UpdateCompanyUseCase;
import com.example.company.domain.port.out.CompanyRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfiguration {

  @Bean
  public CreateCompanyUseCase createCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
    return new CreateCompanyUseCaseImplementation(companyRepositoryPort);
  }

  @Bean
  public UpdateCompanyUseCase updateCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
    return new UpdateCompanyUseCaseImplementation(companyRepositoryPort);
  }

  @Bean
  public GetCompanyUseCase getCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
    return new GetCompanyUseCaseImplementation(companyRepositoryPort);
  }
}
