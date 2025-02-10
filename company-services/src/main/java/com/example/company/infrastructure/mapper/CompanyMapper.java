package com.example.company.infrastructure.mapper;

import com.example.company.domain.model.Company;
import com.example.company.infrastructure.entities.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

  CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

  CompanyEntity companyToCompanyEntity(Company company);

  Company companyEntityToCompany(CompanyEntity companyEntity);
}
