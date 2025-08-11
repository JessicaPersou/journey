package com.persou.journey.employer.interactors;

import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCompanyUseCase {

    private final CompanyRepository companyRepository;

    public RegisterCompanyUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company registerCompany(Company company) {
        return companyRepository.create(company);
    }
}
