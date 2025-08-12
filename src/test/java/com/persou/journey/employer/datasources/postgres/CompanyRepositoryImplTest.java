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
    void shouldFindByIdAndTenantId() {
        String id = "company-id-123";
        String tenantId = "tenant1";
        CompanyModel model = mock(CompanyModel.class);
        Company company = mock(Company.class);

        when(companyJpaRepository.findByIdAndTenantId(id, tenantId)).thenReturn(Optional.of(model));
        when(companyMapper.mapToDomain(model)).thenReturn(company);

        var result = companyRepositoryImpl.findById(id, tenantId);
        assertThat(result).isEqualTo(company);

        verify(companyJpaRepository).findByIdAndTenantId(id, tenantId);
        verify(companyMapper).mapToDomain(model);
    }

    @Test
    void shouldThrowExceptionWhenNotFoundByIdAndTenantId() {
        String id = "notfound";
        String tenantId = "tenant1";
        when(companyJpaRepository.findByIdAndTenantId(id, tenantId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> companyRepositoryImpl.findById(id, tenantId));
        verify(companyJpaRepository).findByIdAndTenantId(id, tenantId);
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
