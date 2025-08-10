package com.persou.journey.employer.repositories;

import com.persou.journey.employer.entities.Department;

public interface DepartmentRepository {
    Department findById(String id);
}
