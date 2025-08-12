package com.persou.journey.employer.interactors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.datasources.multitenant.TenantContext;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class FindCompanyUseCaseTest {

    private final CompanyRepository companyRepository = mock();

    private final FindCompanyUseCase useCase = new FindCompanyUseCase(companyRepository);

    @Test
    void shouldFindCompany() {
        String id = "empresa-123";
        String tenantId = "tenant1";
        Company company = mock(Company.class);

        try (MockedStatic<TenantContext> tenantContextMock = mockStatic(TenantContext.class)) {
            tenantContextMock.when(TenantContext::getCurrentTenant).thenReturn(tenantId);
            when(companyRepository.findById(id, tenantId)).thenReturn(company);

            Company resultado = useCase.findById(id);

            assertThat(resultado).isEqualTo(company);
            verify(companyRepository).findById(id, tenantId);
        }
    }
}