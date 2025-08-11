package com.persou.journey.employer.interactors;

import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class FindCompanyUseCase {

    private final CompanyRepository companyRepository;

    public FindCompanyUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findById(String id) {
        return companyRepository.findById(id);
    }

}
