package com.persou.journey.employer.transportlayers.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.interactors.FindCompanyUseCase;
import com.persou.journey.employer.interactors.RegisterCompanyUseCase;
import com.persou.journey.employer.transportlayers.request.CompanyRequest;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class CompanyApiTest {

    private final FindCompanyUseCase findCompanyUseCase = mock(FindCompanyUseCase.class);
    private final RegisterCompanyUseCase registerCompanyUseCase = mock(RegisterCompanyUseCase.class);
    private final CompanyMapper companyMapper = mock(CompanyMapper.class);
    private final CompanyApi companyApi = new CompanyApi(findCompanyUseCase, registerCompanyUseCase, companyMapper);

    @Test
    void shouldFindCompanyById() {
        String id = "1";
        Company company = Company.builder().id(id).name("TestCo").build();
        CompanyResponse response = CompanyResponse.builder().id(id).name("TestCo").build();
        when(findCompanyUseCase.findById(id)).thenReturn(company);
        when(companyMapper.mapToResponse(company)).thenReturn(response);

        CompanyResponse result = companyApi.findById(id);
        assertThat(result).isNotNull().isEqualTo(response);
        verify(findCompanyUseCase, atLeastOnce()).findById(id);
    }

    @Test
    void shouldThrowExceptionWhenCompanyNotFound() {
        String id = "999";
        when(findCompanyUseCase.findById(id)).thenThrow(new NoSuchElementException("Company not found"));

        try {
            companyApi.findById(id);
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage()).isEqualTo("Company not found");
        }
        verify(findCompanyUseCase, atLeastOnce()).findById(id);
    }

    @Test
    void shouldCreateCompanyById() {
        CompanyRequest request = CompanyRequest.builder().name("TestCo").build();
        Company company = Company.builder().id("1").name("TestCo").build();
        CompanyResponse response = CompanyResponse.builder().id("1").name("TestCo").build();
        when(companyMapper.mapToDomain(request)).thenReturn(company);
        when(registerCompanyUseCase.registerCompany(company)).thenReturn(company);
        when(companyMapper.mapToResponse(company)).thenReturn(response);

        CompanyResponse result = companyApi.save(request);
        assertThat(result).isNotNull().isEqualTo(response);
        verify(registerCompanyUseCase, atLeastOnce()).registerCompany(company);
    }

    @Test
    void shouldThrowExceptionWhenCompanyCreationFails() {
        CompanyRequest request = CompanyRequest.builder().name("TestCo").build();
        Company company = Company.builder().id("1").name("TestCo").build();
        when(companyMapper.mapToDomain(request)).thenReturn(company);
        when(registerCompanyUseCase.registerCompany(company)).thenThrow(new IllegalStateException("Failed to create company"));

        try {
            companyApi.save(request);
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("Failed to create company");
        }
        verify(registerCompanyUseCase, atLeastOnce()).registerCompany(company);
    }
}
