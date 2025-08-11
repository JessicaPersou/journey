package com.persou.journey.employer.datasources.postgres;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.DepartmentMapper;
import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.entities.Department;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class DepartmentRepositoryImplTest {

    private final DepartmentJpaRepository departmentJpaRepository = mock();
    private final DepartmentMapper departmentMapper = mock();
    private final DepartmentRepositoryImpl departmentRepository =
        new DepartmentRepositoryImpl(departmentJpaRepository, departmentMapper);

    @Test
    void shouldFindById() {
        String id = "dep-1";
        DepartmentModel model = mock(DepartmentModel.class);
        Department department = mock(Department.class);

        when(departmentJpaRepository.findById(id)).thenReturn(Optional.of(model));
        when(departmentMapper.mapToDomain(model)).thenReturn(department);

        Department result = departmentRepository.findById(id);

        assertEquals(department, result);
        verify(departmentJpaRepository).findById(id);
        verify(departmentMapper).mapToDomain(model);
    }

    @Test
    void shouldThrowWhenNotFound() {
        String id = "not-found";
        when(departmentJpaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> departmentRepository.findById(id));
        verify(departmentJpaRepository).findById(id);
        verifyNoInteractions(departmentMapper);
    }
}