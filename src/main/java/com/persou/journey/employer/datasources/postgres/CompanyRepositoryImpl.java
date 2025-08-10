package com.persou.journey.employer.datasources.postgres;

import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.repositories.CompanyRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Company findById(String id) {
        Optional<CompanyModel> entityOpt = companyJpaRepository.findById(id);
        return entityOpt.map(companyMapper::toDomain).orElse(null);
    }

    @Override
    public Company create(Company company) {
        CompanyModel modelToSave = companyJpaRepository.save(companyMapper.mapToEntity(company));
        return companyMapper.toDomain(modelToSave);
    }


}

