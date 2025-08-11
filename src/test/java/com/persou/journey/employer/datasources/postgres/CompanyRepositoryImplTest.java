package com.persou.journey.employer.datasources.postgres;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.entities.Company;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class CompanyRepositoryImplTest {

    private final CompanyJpaRepository companyJpaRepository = mock();
    private final CompanyMapper companyMapper = mock();
    private final CompanyRepositoryImpl companyRepositoryImpl =
        new CompanyRepositoryImpl(companyJpaRepository, companyMapper);

    @Test
    void shouldFindById() {
        String id = "company-id-123";
        CompanyModel model = mock(CompanyModel.class);
        Company company = mock(Company.class);

        when(companyJpaRepository.findById(id)).thenReturn(Optional.of(model));
        when(companyMapper.mapToDomain(model)).thenReturn(company);

        var result = companyRepositoryImpl.findById(id);
        assertThat(result).isEqualTo(company);

        verify(companyJpaRepository).findById(id);
        verify(companyMapper).mapToDomain(model);
    }

    @Test
    void shouldThrowExceptionWhenNotFound() {
        String id = "notfound";
        when(companyJpaRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> companyRepositoryImpl.findById(id));
        verify(companyJpaRepository).findById(id);
    }

    @Test
    void shouldCreateCompany() {
        Company company = mock(Company.class);
        CompanyModel model = mock(CompanyModel.class);
        when(companyMapper.mapToEntity(company)).thenReturn(model);
        when(companyJpaRepository.save(model)).thenReturn(model);
        when(companyMapper.mapToDomain(model)).thenReturn(company);

        Company result = companyRepositoryImpl.create(company);
        assertThat(result).isEqualTo(company);
        verify(companyMapper).mapToEntity(company);
        verify(companyJpaRepository).save(model);
        verify(companyMapper).mapToDomain(model);
    }
}
