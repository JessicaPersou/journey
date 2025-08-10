package com.persou.journey.employer.repositories;

import com.persou.journey.employer.entities.Employee;

public interface EmployeeRepository {
    Employee findById(String id);
}
