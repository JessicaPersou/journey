package com.persou.journey.employer.interactors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.entities.Address;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.repositories.CompanyRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class FindCompanyUseCaseTest {

    private final CompanyRepository companyRepository = mock();

    private final FindCompanyUseCase useCase = new FindCompanyUseCase(companyRepository);

    @Test
    void shouldFindCompany() {
        Company company = new Company(
            UUID.randomUUID().toString(),
            "company",
            "1234567000100",
            new Address(
                "Rua da Beleza",
                "123",
                "01541111",
                "Vila Bonita",
                "São Paulo",
                "SP",
                "Brasil"
            ),
            "1198888000",
            "company@email.com"
        );

        when(companyRepository.findById(company.id())).thenReturn(company);

        var result = useCase.findById(company.id());

        assertThat(result).isEqualTo(company).isNotNull();

        verify(companyRepository, times(1)).findById(company.id());
    }
}