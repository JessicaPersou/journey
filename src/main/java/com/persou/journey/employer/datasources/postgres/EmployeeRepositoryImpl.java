package com.persou.journey.employer.datasources.postgres;

import static com.persou.journey.employer.config.exception.MessagesExceptions.NOT_FOUND;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.EmployeeMapper;
import com.persou.journey.employer.datasources.model.EmployeeModel;
import com.persou.journey.employer.entities.Employee;
import com.persou.journey.employer.repositories.EmployeeRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee findById(String id) {
        Optional<EmployeeModel> entityOpt = employeeJpaRepository.findById(id);
        return entityOpt.map(employeeMapper::mapToDomain).orElseThrow(() ->
            new ResourceNotFoundException(NOT_FOUND + id));
    }

}

