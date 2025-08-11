package com.persou.journey.employer.datasources.postgres;

import static com.persou.journey.employer.config.exception.MessagesExceptions.NOT_FOUND;

import com.persou.journey.employer.config.exception.ResourceNotFoundException;
import com.persou.journey.employer.datasources.mapper.DepartmentMapper;
import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.entities.Department;
import com.persou.journey.employer.repositories.DepartmentRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentRepositoryImpl(DepartmentJpaRepository departmentJpaRepository,
                                    DepartmentMapper departmentMapper) {
        this.departmentJpaRepository = departmentJpaRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Department findById(String id) {
        Optional<DepartmentModel> entityOpt = departmentJpaRepository.findById(id);
        return entityOpt.map(departmentMapper::mapToDomain)
            .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
    }
}
