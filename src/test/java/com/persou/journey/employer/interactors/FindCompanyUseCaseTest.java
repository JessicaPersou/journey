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
        Company company = Company.builder()
            .id(UUID.randomUUID().toString())
            .name("company")
            .cnpj("1234567000100")
            .phone("1198888000")
            .email("company@email.com")
            .address(Address.builder()
                .street("Rua da Beleza")
                .number("123")
                .zipcode("01541111")
                .neighborhood("Vila Bonita")
                .city("São Paulo")
                .state("SP")
                .country("Brasil")
                .build()).build();

        when(companyRepository.findById(company.id())).thenReturn(company);

        var result = useCase.findById(company.id());

        assertThat(result).isEqualTo(company).isNotNull();

        verify(companyRepository, times(1)).findById(company.id());
    }
}