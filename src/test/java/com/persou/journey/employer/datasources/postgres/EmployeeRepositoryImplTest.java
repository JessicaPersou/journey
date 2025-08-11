package com.persou.journey.employer.datasources.postgres;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.EmployeeMapper;
import com.persou.journey.employer.datasources.model.EmployeeModel;
import com.persou.journey.employer.entities.Employee;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class EmployeeRepositoryImplTest {

    private final EmployeeJpaRepository employeeJpaRepository = mock();
    private final EmployeeMapper employeeMapper = mock();
    private final EmployeeRepositoryImpl employeeRepositoryImpl =
        new EmployeeRepositoryImpl(employeeJpaRepository, employeeMapper);

    @Test
    void shouldFindById(){
        String id = "employee-id-123";
        EmployeeModel model = mock(EmployeeModel.class);
        Employee employee = mock(Employee.class);

        when(employeeJpaRepository.findById(id)).thenReturn(Optional.of(model));
        when(employeeMapper.mapToDomain(model)).thenReturn(employee);

        var result = employeeRepositoryImpl.findById(id);
        assertThat(result).isEqualTo(employee);

        verify(employeeJpaRepository).findById(id);
        verify(employeeMapper).mapToDomain(model);
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound(){
        String id = "notfound";
        when(employeeJpaRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> employeeRepositoryImpl.findById(id));
        verify(employeeJpaRepository).findById(id);
    }

}