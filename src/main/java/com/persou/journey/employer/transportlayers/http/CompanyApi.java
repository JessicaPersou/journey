package com.persou.journey.employer.transportlayers.http;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.persou.journey.employer.datasources.mapper.CompanyMapper;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.interactors.FindCompanyUseCase;
import com.persou.journey.employer.interactors.RegisterCompanyUseCase;
import com.persou.journey.employer.transportlayers.request.CompanyRequest;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyApi {

    private final FindCompanyUseCase companyUseCase;
    private final RegisterCompanyUseCase registerCompanyUseCase;
    private final CompanyMapper companyMapper;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CompanyResponse findById(@PathVariable String id) {
        Company company = companyUseCase.findById(id);
        return companyMapper.mapToResponse(company);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CompanyResponse save(@RequestBody CompanyRequest request) {
        Company company = registerCompanyUseCase.registerCompany(companyMapper.mapToDomain(request));
        return companyMapper.mapToResponse(company);
    }
}
