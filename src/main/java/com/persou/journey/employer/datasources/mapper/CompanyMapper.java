package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.transportlayers.request.CompanyRequest;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {

    CompanyResponse mapToResponse(Company domain);

    Company mapToDomain(CompanyRequest request);

    CompanyModel mapToEntity(Company domain);

    Company mapToDomain(CompanyModel model);
}
