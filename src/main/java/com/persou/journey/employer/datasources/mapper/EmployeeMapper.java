package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.EmployeeModel;
import com.persou.journey.employer.entities.Employee;
import com.persou.journey.employer.transportlayers.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    EmployeeResponse mapToResponse(Employee domain);

    EmployeeModel mapToEntity(Employee domain);

    Employee mapToDomain(EmployeeResponse response);

    Employee mapToDomain(EmployeeModel model);
}
