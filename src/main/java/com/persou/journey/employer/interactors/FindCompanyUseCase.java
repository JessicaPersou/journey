package com.persou.journey.employer.interactors;

import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCompanyUseCase {

    private final CompanyRepository companyRepository;

    public Company findById(String id) {
        return companyRepository.findById(id);
    }
    
}
