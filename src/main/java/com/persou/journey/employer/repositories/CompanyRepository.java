package com.persou.journey.employer.repositories;

import com.persou.journey.employer.entities.Company;

public interface CompanyRepository {
    Company findById(String id);
    Company create(Company company);
}
