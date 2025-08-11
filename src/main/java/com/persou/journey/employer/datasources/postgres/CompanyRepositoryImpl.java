package com.persou.journey.employer.datasources.postgres;

import static com.persou.journey.employer.config.exception.MessagesExceptions.NOT_FOUND;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyRepositoryImpl implements CompanyRepository {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

    public CompanyRepositoryImpl(CompanyJpaRepository companyJpaRepository, CompanyMapper companyMapper) {
        this.companyJpaRepository = companyJpaRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public Company findById(String id) {
        Optional<CompanyModel> entityOpt = companyJpaRepository.findById(id);
        return entityOpt.map(companyMapper::mapToDomain).orElseThrow(() ->
            new ResourceNotFoundException(NOT_FOUND + id));
    }

    @Override
    public Company create(Company company) {
        CompanyModel modelToSave = companyJpaRepository.save(companyMapper.mapToEntity(company));
        return companyMapper.mapToDomain(modelToSave);
    }


}

