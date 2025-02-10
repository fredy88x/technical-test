package com.example.company.domain.port.in;

import com.example.company.domain.model.Company;
import java.util.List;
import java.util.Optional;

public interface GetCompanyUseCase {

  Optional<Company> getCompany(String companyId);

  List<Company> getCompanies();
}
