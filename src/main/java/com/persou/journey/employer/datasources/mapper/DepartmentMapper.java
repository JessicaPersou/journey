package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.entities.Department;
import com.persou.journey.employer.transportlayers.response.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {

    DepartmentResponse mapToResponse(Department domain);

    DepartmentModel mapToEntity(Department domain);

    Department mapToDomain(DepartmentResponse response);

    Department mapToDomain(DepartmentModel model);
}
