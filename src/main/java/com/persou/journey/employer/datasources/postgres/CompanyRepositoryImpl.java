package com.persou.journey.employer.datasources.postgres;

import static com.persou.journey.employer.config.exception.MessagesExceptions.NOT_FOUND;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

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

