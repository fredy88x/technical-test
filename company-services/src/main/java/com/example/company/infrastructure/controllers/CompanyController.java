package com.example.company.infrastructure.controllers;

import com.example.company.domain.model.Company;
import com.example.company.domain.port.in.CreateCompanyUseCase;
import com.example.company.domain.port.in.GetCompanyUseCase;
import com.example.company.domain.port.in.UpdateCompanyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/company")
public class CompanyController {

  private final CreateCompanyUseCase createCompanyUseCase;
  private final GetCompanyUseCase getCompanyUseCase;
  private final UpdateCompanyUseCase updateCompanyUseCase;

  public CompanyController(CreateCompanyUseCase createCompanyUseCase,
      GetCompanyUseCase getCompanyUseCase, UpdateCompanyUseCase updateCompanyUseCase) {
    this.createCompanyUseCase = createCompanyUseCase;
    this.getCompanyUseCase = getCompanyUseCase;
    this.updateCompanyUseCase = updateCompanyUseCase;
  }

  @PostMapping
  public ResponseEntity<?> createCompany(@RequestBody Company company) {
    return new ResponseEntity<>(createCompanyUseCase.createCompany(company), HttpStatus.CREATED);
  }

  @GetMapping("/{companyId}")
  public ResponseEntity<?> getCompanyById(@PathVariable String companyId) {
    return getCompanyUseCase.getCompany(companyId)
        .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getCompanyUseCase.getCompanies(), HttpStatus.OK);
  }

  @PutMapping("/{companyId}")
  public ResponseEntity<?> updateCompany(@PathVariable String companyId,
      @RequestBody Company company) {
    return updateCompanyUseCase.updateCompany(companyId, company)
        .map(companyElement -> new ResponseEntity<>(companyElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
